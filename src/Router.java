import java.util.ArrayList;
import java.util.List;

/**
 * Router class is nothing but a node in any graph
 * So any Router in the network should have the following
 * List of its neighbors
 * RouterLinks connecting to each of its neighbors
 * So based, on the above requirements we need the following instance variables
 * Routers[]: listOfNeighbors
 * RouterLinks[]: listOfRouterLinks
 *
 * One more IMPORTANT variable in the Distance-vector-routing is that
 * Every Router contains its own RoutingTable. so RoutingTable here will be considered as another instance variable
 */
public class Router {

    private List<Router> listOfNeighboringRouters;
    private List<RouterLink> listOfRouterLinks;
    private RoutingTable myRoutingTable;

    public Router() {
        this.listOfNeighboringRouters = new ArrayList<>();
        this.listOfRouterLinks = new ArrayList<>();
        this.myRoutingTable = new RoutingTable();
    }

    public void addToListOfNeighboringRouters(Router newNeighborRouter) {
        this.listOfNeighboringRouters.add(newNeighborRouter);
    }

    public void addToListOfRouterLinks(RouterLink newRouterLink) {
        this.listOfRouterLinks.add(newRouterLink);
    }


    /**
     * Each Router can do its THING, which is
     * 1. send messages to its neighbors
     * 2. receive messages from its neighbors
     * 3. update its routing Table based on the messages
     * Check readme.md for more detailed explanation
     */
}

