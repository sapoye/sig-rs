document.addEventListener("DOMContentLoaded", function() {
    if (document.getElementById('map')) {
        var map = L.map('map').setView([14.6928, -17.4467], 12); // Exemple : Dakar
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; OpenStreetMap contributors'
        }).addTo(map);
        // Ajoute ici d'autres marqueurs si besoin
    }
});