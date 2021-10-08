function updateView(gates, flights) {
    let tableBodyElement = document.querySelector('table.flights tbody');

    const gateButtonsHtml = gates.map(gate => {
        return `<button data-gate-number="${gate.number}" ${gate.is_available ? '' : 'disabled'}>${gate.number}</button>`;
    }).join('');

    const humanReadableTime = (time) => {
        const date = new Date(time);
        return `${date.getUTCFullYear()}-${('0' + (date.getUTCMonth() + 1)).slice(-2)}-${('0' + date.getUTCDate()).slice(-2)} 
                ${('0' + date.getUTCHours()).slice(-2)}:${('0' + date.getUTCMinutes()).slice(-2)}`;
    };
    
    let html = flights.map(flight => {
        return `
            <tr data-flight-id="${flight.id}">
                <td>${humanReadableTime(flight.flown_at)}</td>
                <td>${flight.route_number}</td>
                <td>${flight.origin_airport.iata_code}</td>
                <td>${flight.destination_airport.iata_code}</td>
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
            findByNumber: number => gates.find(gate => gate.number == number),
            save: gate => saveData('http://localhost:8080/gates', gate)
        },
        flights: {
            findAll: () => flights,
            findById: id => flights.find(flight => flight.id == id),
            save: flight => saveData('http://localhost:8080/flights', flight)
        },
        checklists: {
            findAll: () => checklists,
            findById: id => checklists.find(checklist => checklist.id == id),
            findByFlightId: flightId => checklists.filter(checklist => checklist.flight_id == flightId),
            save: checklist => saveData('http://localhost:8080/checklists', checklist)
        },
        fetch: () => {
            return Promise.all([
                fetch('http://localhost:8080/gates')
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
                // fetch('http://localhost:8080/flights')
                //     .then(response => response.json())
                //     .then(data => { 
                //         flights = data;
                //     })
                new Promise((resolve, reject) => {
                    setTimeout(() => {
                        data = [
                            {
                                "id": 1,
                                "origin_airport": {
                                    "iata_code": "KRK",
                                    "city_name": "Krakow (Cracow) - John Paul II International Airport",
                                    "country_name": "Poland"
                                },
                                "destination_airport": {
                                    "iata_code": "CPH",
                                    "city_name": "Copenhagen - Copenhagen Airport",
                                    "country_name": "Denmark"
                                },
                                "gate": null,
                                "flown_at": "2021-10-18T22:10:00.000+00:00",
                                "route_number": "D8 3563",
                                "aircraft_type": {
                                    "icaocode": "B738",
                                    "iata_code": "73H",
                                    "icao_code": "B738",
                                    "model_name": "Boeing 737-800 (winglets) pax",
                                    "wake_category": "MEDIUM"
                                }
                            },
                            {
                                "id": 2,
                                "origin_airport": {
                                    "iata_code": "AHO",
                                    "city_name": "Alghero Sassari",
                                    "country_name": "Italy"
                                },
                                "destination_airport": {
                                    "iata_code": "CPH",
                                    "city_name": "Copenhagen - Copenhagen Airport",
                                    "country_name": "Denmark"
                                },
                                "gate": null,
                                "flown_at": "2021-10-18T22:10:00.000+00:00",
                                "route_number": "JTG360",
                                "aircraft_type": {
                                    "icaocode": "B738",
                                    "iata_code": "73H",
                                    "icao_code": "B738",
                                    "model_name": "Boeing 737-800 (winglets) pax",
                                    "wake_category": "MEDIUM"
                                }
                            },
                            {
                                "id": 3,
                                "origin_airport": {
                                    "iata_code": "ARN",
                                    "city_name": "Stockholm - Arlanda",
                                    "country_name": "Sweden"
                                },
                                "destination_airport": {
                                    "iata_code": "CPH",
                                    "city_name": "Copenhagen - Copenhagen Airport",
                                    "country_name": "Denmark"
                                },
                                "gate": null,
                                "flown_at": "2021-10-18T22:10:00.000+00:00",
                                "route_number": "SK 9250",
                                "aircraft_type": {
                                    "icaocode": "CRJ9",
                                    "iata_code": "CR9",
                                    "icao_code": "CRJ9",
                                    "model_name": "Canadair Regional Jet 900",
                                    "wake_category": "MEDIUM"
                                }
                            }
                        ];
                        flights = data;
                        resolve(data);
                    }, 750);
                })
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
        if (e.target.dataset.gateNumber) {

            e.preventDefault();

            let gateNumber = e.target.dataset.gateNumber;
            let gate = cache.gates.findByNumber(gateNumber);

            gate.is_available = false;
            cache.gates.save(gate);

            let flightId = e.target.closest('tr').dataset.flightId;
            let flight = cache.flights.findById(flightId);

            flight.gate = gate;
            cache.flights.save(flight);

            updateView(cache.gates.findAll(), cache.flights.findAll());
        }
    });
});


