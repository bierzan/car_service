package pl.coderslab.model;

public enum Status {
    orderAccepted("order accepted"),
    costAccepted("cost accepted"),
    inRepair("in repair"),
    ready("ready"),
    cancelled("cancelled");

    private String displayStatus;

    Status(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    @Override
    public String toString() {
        return displayStatus;
    }

}



