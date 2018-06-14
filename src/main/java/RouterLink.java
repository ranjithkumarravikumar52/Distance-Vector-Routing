/**
 * RouterLink class is nothing but an edge or a connection from one Router to another router
 * Parameters needed are the following
 * Router: sourceRouter
 * Router: destinationRouter
 * Double: linkCost
 */
public class RouterLink {
    private Router sourceRouter;
    private Router destinationRouter;
    private double linkCost;

    public RouterLink(Router sourceRouter, Router destinationRouter, double linkCost) {
        this.sourceRouter = sourceRouter;
        this.destinationRouter = destinationRouter;
        this.linkCost = linkCost;
    }

    public Router getSourceRouter() {
        return sourceRouter;
    }

    public Router getDestinationRouter() {
        return destinationRouter;
    }

    public double getLinkCost() {
        return linkCost;
    }

}
