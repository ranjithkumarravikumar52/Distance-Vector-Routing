/**
 * Name: Ranjith Kumar Ravikumar
 */

public class App {

    public static void main(String[] args) {
        Router X = new Router("X");
        Router Y = new Router("Y");
        Router Z = new Router("Z");



        X.getMyRoutingTable().printRoutingTable();
        Y.getMyRoutingTable().printRoutingTable();
        Z.getMyRoutingTable().printRoutingTable();
    }

}
