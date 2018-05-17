/**
 * Routing table should contain the following parameters for every Router
 * Type: Variable Name
 * Router: Destination
 * Double: Estimated cost to Destination
 * Router: Next Hop to reach the Destination (can also be considered as "via")
 */
public class RoutingRowInformation {

    private Router destinationRouter;
    private double costToDestination;
    private Router nextHopToDestination;

    public RoutingRowInformation(Router destinationRouter, double costToDestination, Router nextHopToDestination) {
        this.destinationRouter = destinationRouter;
        this.costToDestination = costToDestination;
        this.nextHopToDestination = nextHopToDestination;
    }

    public Router getDestinationRouter() {
        return destinationRouter;
    }

    public void setDestinationRouter(Router destinationRouter) {
        this.destinationRouter = destinationRouter;
    }

    public double getCostToDestination() {
        return costToDestination;
    }

    public void setCostToDestination(double costToDestination) {
        this.costToDestination = costToDestination;
    }

    public Router getNextHopToDestination() {
        return nextHopToDestination;
    }

    public void setNextHopToDestination(Router nextHopToDestination) {
        this.nextHopToDestination = nextHopToDestination;
    }
}