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
    private String routerName;
    private List<Router> listOfNeighboringRouters;
    private List<RouterLink> listOfRouterLinks;
    private RoutingTable myRoutingTable;

    public Router(String routerName) {
        this.routerName = routerName;
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

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public RoutingTable getMyRoutingTable() {
        return myRoutingTable;
    }

    public void setMyRoutingTable(RoutingTable myRoutingTable) {
        this.myRoutingTable = myRoutingTable;
    }

    /**
     * PROTOCOL FRAMEWORK
     * Initial State at a node: Cost (distance) to its neighbors is known
     * Final State at a node: Cost to all its nodes is known and also the next hop
     */
    //TODO Initialization phase for Routers

    //TODO sendMessageToNeighbors

    //TODO receiveMessageFromNeighbors

    //TODO updateRoutingTable


    /**
     * Each Router can do its THING, which is
     * 1. send messages to its neighbors
     * 2. receive messages from its neighbors
     * 3. update its routing Table based on the messages
     * Check readme.md for more detailed explanation
     */

}

