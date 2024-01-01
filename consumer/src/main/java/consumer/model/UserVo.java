package consumer.model;

public class UserVo {
    private String id;
    private String name;

    public UserVo() {
    }

    public UserVo(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserVo{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}
