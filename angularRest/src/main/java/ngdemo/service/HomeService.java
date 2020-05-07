package ngdemo.service;

import ngdemo.domain.Home;


public class HomeService {

    public Home getDefaultHome() {
        Home home = new Home();
        home.setFirstName("PHX DEMO");
        home.setLastName("PHX swap list.");
        home.setBmp("phx.jpeg");
        return home;
    }
    
}