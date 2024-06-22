package sg.edu.np.mad.madpractical4;

public class User {
    String name;
    String description;
    int id;
    boolean followed;

    public void setName(String username){this.name = username;}
    public void setDescription(String description){this.description = description;}
    public void setId(int id){this.id = id;}
    public void setFollowed(boolean Followed){this.followed = followed;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public boolean getFollowed(){return followed;}
    public User(String n, String d, int i, boolean f) {
        name = n;
        description = d;
        id = i;
        followed = f;
    }
}