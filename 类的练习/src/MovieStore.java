import java.util.*;
public class MovieStore {
    private Hashtable     movieList, actorList, typeList; public Hashtable getMovieList() { return movieList; }
    public Hashtable getActorList() { return actorList; }
    public Hashtable getTypeList() { return typeList; }
    public MovieStore() {
        movieList = new Hashtable();
        actorList = new Hashtable();
        typeList  = new Hashtable();
    }
    public String toString() {
        return ("MovieStore with " + movieList.size() + " movies.");
    }
    //向MovieStore对象中增加一个Movie对象
    public void addMovie(Movie aMovie) {
        movieList.put(aMovie.getTitle(), aMovie);
        if (!typeList.containsKey(aMovie.getType()))
            typeList.put(aMovie.getType(), new Vector());
        ((Vector)typeList.get(aMovie.getType())).add(aMovie);
        for (int i=0; i<aMovie.getActors().size(); i++) {
            String anActor = (String)aMovie.getActors().get(i);
            if (!actorList.containsKey(anActor))
                actorList.put(anActor, new Vector());
            ((Vector)actorList.get(anActor)).add(aMovie);
        }
    }
    //从MovieStore中删除一个Movie对象
    private void removeMovie(Movie aMovie) {
        movieList.remove(aMovie.getTitle());
        ((Vector)typeList.get(aMovie.getType())).remove(aMovie);
        if (((Vector)typeList.get(aMovie.getType())).isEmpty())
            typeList.remove(aMovie.getType());
        for(int i=0; i<aMovie.getActors().size(); i++) {
            String anActor = (String)aMovie.getActors().get(i);
            ((Vector)actorList.get(anActor)).remove(aMovie);
            if (((Vector)actorList.get(anActor)).isEmpty())
                actorList.remove(anActor);
        }
    }
    //已知一个Movie对象的title，将其从MovieStore对象中删除
    public void removeMovie(String aTitle) {
        if (movieList.get(aTitle) == null)
            System.out.println("No movie with that title");
        else
            removeMovie((Movie)movieList.get(aTitle));
    }
    //输出所有Movie对象的标题
    public void listMovies() {
        Enumeration  titles = movieList.keys();
        while(titles.hasMoreElements())
            System.out.println(titles.nextElement());
    }
    //输出给定演员参加的所有电影
    public void listMoviesWithActor(String anActor) {
        Enumeration someMovies = ((Vector)actorList.get(anActor)).elements();
        while(someMovies.hasMoreElements())
            System.out.println(someMovies.nextElement());
    }
    //输出属于给定类型的所有电影
    public void listMoviesOfType(String aType) {
        Enumeration  someMovies = ((Vector)typeList.get(aType)).elements();
        while(someMovies.hasMoreElements())
            System.out.println(someMovies.nextElement());
    }



}
