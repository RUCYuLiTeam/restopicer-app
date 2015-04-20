package restopicerapp.appmodelrepository;

public class RecommendedPaper {

    private final long id;
    private final String content;

    public RecommendedPaper(long id, String content) {
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
