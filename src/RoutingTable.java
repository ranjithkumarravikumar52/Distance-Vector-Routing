import java.util.ArrayList;
import java.util.List;

public class RoutingTable {
    private List<RoutingRowInformation> routingRowList;

    public RoutingTable() {
        this.routingRowList = new ArrayList<>();
    }

    public void addRoutingRowToTheTable(RoutingRowInformation newRoutingRow){
        this.routingRowList.add(newRoutingRow);
    }

    public List<RoutingRowInformation> getRoutingRowList() {
        return routingRowList;
    }

    //TODO provide a method to display Routing Table Information

}
