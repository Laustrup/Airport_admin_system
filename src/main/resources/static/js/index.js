function updateView(gates, flights) {
    let tableBodyElement = document.querySelector('table.flights tbody');

    const gateButtonsHtml = gates.map(gate => {
        return `<button data-gate-id="${gate.id}" ${gate.is_available ? '' : 'disabled'}>${gate.number}</button>`;
    }).join('');

    let html = flights.map(flight => {
        return `
            <tr data-flight-id="${flight.id}">
                <td></td>
                <td>${flight.route_number}</td>
                <td>${flight.origin_airport}</td>
                <td>${flight.destination_airport}</td>
                <td>
                    ${gateButtonsHtml}
                </td>
            </tr>
        `;
    }).join('');

    tableBodyElement.innerHTML = html;
}

function localCache() {
    let gates = [];
    let flights = [];
    let checklists = [];

    function saveData(url, data, primaryKey = 'id') {
        const method = data[primaryKey] ? 'PUT' : 'POST';
        const options = {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        };

        url = method === 'PUT' ? `${url}/${data[primaryKey]}` : url;
        fetch(url, options);
    }

    return {
        gates: {
            findAll: () => gates,
            findAllAvailable: () => gates.filter(gate => gate.is_available),
            findById: id => gates.find(gate => gate.id == id),
            save: gate => saveData('http://localhost:8080/allGatesInformation', gate)
        },
        flights: {
            findAll: () => flights,
            findById: id => flights.find(flight => flight.id == id),
            save: flight => saveData('http://localhost:8080/allAircraftsInformation', flight)
        },
        checklists: {
            findAll: () => checklists,
            findById: id => checklists.find(checklist => checklist.id == id),
            findByFlightId: flightId => checklists.filter(checklist => checklist.flight_id == flightId),
            save: checklist => saveData('http://localhost:8080/checklists', checklist)
        },
        fetch: () => {
            return Promise.all([
                fetch('http://localhost:8080/allGatesInformation')
                    .then(response => response.json())
                    .then(data => {
                        gates = data;
                    }),
                // new Promise((resolve, reject) => {
                //     setTimeout(() => {
                //         data = [
                //             { id: 1, number: 1, is_available: true, wake_category: 1 },
                //             { id: 2, number: 2, is_available: true, wake_category: 1 },
                //             { id: 3, number: 3, is_available: false, wake_category: 3 },
                //             { id: 4, number: 4, is_available: true, wake_category: 2 }
                //         ];
                //         gates = data;
                //         resolve(data);
                //     }, 750);
                // }),
                fetch('http://localhost:8080/allAircraftsInformation')
                    .then(response => response.json())
                    .then(data => { 
                        flights = data;
                    })
                // new Promise((resolve, reject) => {
                //     setTimeout(() => {
                //         data = [
                //             { id: 1, origin_airport: 'ARN', destination_airport: 'CPH', route_number: 'SK 1435' },
                //             { id: 2, origin_airport: 'CPH', destination_airport: 'ARN', route_number: 'SK 1438' },
                //             { id: 3, origin_airport: 'OSL', destination_airport: 'CPH', route_number: 'SK 1431' }
                //         ];
                //         flights = data;
                //         resolve(data);
                //     }, 750);
                // }),
                // new Promise((resolve, reject) => {
                //     setTimeout(() => {
                //         data = [
                //             { has_refueled: false, has_passengers: false, has_cargo: false, flight_id: 1 },
                //             { has_refueled: false, has_passengers: false, has_cargo: false, flight_id: 2 },
                //             { has_refueled: false, has_passengers: false, has_cargo: false, flight_id: 3 }
                //         ];
                //         checklists = data;
                //         resolve(data);
                //     }, 750);
                // })
            ]);
        }
    };
}

const loadingIconElement = document.querySelector('.loading-icon');
loadingIconElement.hidden = false;

const cache = localCache();
cache.fetch().then(() => {
    
    loadingIconElement.hidden = true;
    
    updateView(cache.gates.findAll(), cache.flights.findAll());
    
    document.addEventListener('click', (e) => {
        if (e.target.dataset.gateId) {
            
            e.preventDefault();

            let gateId = e.target.dataset.gateId;
            let gate = cache.gates.findById(gateId);
            
            gate.is_available = false;
            cache.gates.save(gate);
        }
    });
});


