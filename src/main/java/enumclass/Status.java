package enumclass;

public enum Status {
    START("a") ,
    RUNNING("b"),
    STOP;

    private Status() {
        this("def");
    }

    private Status(String name){
        this.name = name;
    }

    public String name;


}


