package Archive;


public class Node1 {
    //fields:
    private String item;
    private Node1 link;


    public Node1() {
        this.item = null;
        this.link = null;
    }

    public Node1(String item, Node1 link) {
        setData(item);
        this.link = link;
    }

    private void setData(String i) {
        item = i;
    }


    public void setLink(Node1 link) {
        this.link = link;
    }

    public String getItem() {
        return item;
    }

    public Node1 getLink() {
        return link;
    }
}
