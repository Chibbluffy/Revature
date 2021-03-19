
    function parseJWT(token){
        var base64Url = token.split('.')[1];
        var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));

        return JSON.parse(jsonPayload);
    }
    function logout(){
        sessionStorage.removeItem('sessionToken');
        sessionStorage.removeItem('username');
        update();
    }
    function update(){
        const sessionStorage = window.sessionStorage;
        const token = sessionStorage.getItem("sessionToken");
        console.log(token);
        if (token != null){
            const parsedToken = parseJWT(token);
            if(parsedToken.role.includes("Master")){
                console.log("PRIVILEGES! WOO");
                window.location.href = './master.html';
            }
            else{
                console.log("Normal login");
                window.location.href = './user.html';
            }
        }
        else{
            window.location.href = './main.html';
        }
    }
    async function login(){
        const sessionStorage = window.sessionStorage;

        const username = document.getElementById("inputUsername").value;
        const password = document.getElementById("inputPassword").value;

        const login = {username:username, passhash:password};

        const headers = {method:'POST', body:JSON.stringify(login)};
        let response = await fetch('http://35.232.230.2:7000/login', headers);
        if (response.status != 200){
            const loginMessageSpan = document.getElementById("login-message");
            loginMessageSpan.innerHTML = `
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Invalid Credentials <br/>Please try again.
                </div>
            `;
        }
        else {
            const token = await response.json();
            const parsedToken = parseJWT(token);
            console.log(parsedToken);

            sessionStorage.setItem("sessionToken", token);
            sessionStorage.setItem("username",parsedToken.username);
            update();
        }
    }
    async function getExpenses(){
        const token = window.sessionStorage.getItem('sessionToken');

        const headers = {
            method:'GET',
            headers:{
                Authorization:token
            }
        }

        let response = await fetch('http://35.232.230.2:7000/expenses', headers);
        if (response.status != 200){
            const failedToLoadSpan = document.getElementById("failed-to-load-span");
            failedToLoadSpan.innerHTML = `
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Failed to retrieve data <br/>Please try again later.
                </div>
            `
        }
        else{
            return await response.json();
        }
    }
    function epochToDate(seconds){
        if (seconds == 0){
            return "N/A"
        }else{
            let dt = new Date(0);
            dt.setUTCSeconds(seconds);
            let formattedDate = dt.toString().split("GMT")[0]
            return formattedDate;
        }
    }