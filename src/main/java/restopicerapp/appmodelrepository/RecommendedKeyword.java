package restopicerapp.appmodelrepository;

public class RecommendedKeyword {

    private final long id;
    private final String content;

    public RecommendedKeyword(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
