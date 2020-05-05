package ngdemo.service;

import ngdemo.domain.Home;
import ngdemo.mysql.DBConnect;
import ngdemo.mysql.domain.SQL;

public class HomeService {

    public Home getDefaultHome() {
        Home home = new Home();
        home.setFirstName("PHX DEMO");
        home.setLastName("PHX swap list.");
        home.setBmp("phx.jpeg");
        return home;
    }
    
}