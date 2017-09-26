package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Path("/path")
public class QuizService {
    private static Map<String,Quiz> quizzes = new HashMap<String,Quiz>();
    private static String quizId = "";
    private static int currentQuestion = 0;

    public QuizService(){
        if(quizzes.size() < 1){
            Quiz q = new Quiz();
            q.setId("QuizTest");
            q.setName("Testname");
            q.setStartTime(new Date());
            Question[] que = new Question[2];
            que[0] = new Question();
            que[1] = new Question();
            que[0].setQuestion("Test1");
            que[1].setQuestion("Dette er et testspørsmpl?");
            Alternative[] alt1 = {new Alternative("alt1", true),
                                new Alternative("alt2", false),
                                new Alternative("alt3", false)};
            que[0].setAlternatives(alt1);
            Alternative[] alt2 = {new Alternative("Dette er alternativ 1", true),
                    new Alternative("Et annet alternativ", false),
                    new Alternative("Siste alternativ", false)};
            que[1].setAlternatives(alt2);
            q.setQuestions(que);

            quizzes.put(q.getId(),q);

            Quiz q2 = new Quiz();
            q2.setId("2");
            q2.setName("Testname 2");
            q2.setStartTime(new Date());
            Question[] que2 = new Question[1];
            que2[0] = new Question();
            que2[0].setQuestion("Test2");
            q2.setQuestions(que2);

            quizzes.put(q2.getId(),q2);
        }
    }

    @POST
    @Path("/setCurrentQuestion/{questionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setCurrentQuestion(@PathParam("questionId") int questionId){
        currentQuestion = questionId;
        System.out.println(currentQuestion);
    }

    @POST
    @Path("/setQuiz/{quizId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setQuiz(@PathParam("quizId") String quizId){
        this.quizId = quizId;
        System.out.println(this.quizId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz q){
        q.setId("" + (quizzes.size() + 1));
        quizzes.put(q.getId(), q);
        System.out.println(q.getDemBoys());
    }

    @GET
    @Path("/getCurrentQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public int getCurrentQuestion(){
        return currentQuestion;
    }

    @GET
    @Path("/getQuestionText/{quizId}/{spmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSpm(@PathParam("quizId") String quizId,
                         @PathParam("spmId") int spmId){
        return quizzes.get(quizId).getQuestions()[spmId].getQuestion();
    }

    @GET
    @Path("/getCurrentQuiz")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuizId(){
        return quizId;
    }

    @GET
    @Path("/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Quiz getQuiz(@PathParam("quizId") String quizId) {
        if(quizzes.containsKey(quizId)){
            return quizzes.get(quizId);
        } else {
            throw new javax.ws.rs.NotFoundException();
        }
    }

    @GET
    @Path("/getName/{quizId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuizName(@PathParam("quizId") String quizId){
        if(quizzes.containsKey(quizId)){
            return quizzes.get(quizId).getName();
        } else {
            throw new javax.ws.rs.NotFoundException();
        }
    }

    @GET
    @Path("/getStarttime/{quizId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getQuizStartTime(@PathParam("quizId") String quizId){
        if(quizzes.containsKey(quizId)){
            return quizzes.get(quizId).getStartTime().toString();
        } else {
            throw new javax.ws.rs.NotFoundException();
        }
    }

    @GET
    @Path("/getAlternatives/{quizId}/{questionI}/{altI}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getAlternative(@PathParam("quizId") String quizId,
                                 @PathParam("questionI") int questionI,
                                   @PathParam("altI") int altI){
        if(quizzes.containsKey(quizId)){
            String[] out = new String[2];
            out[0] = quizzes.get(quizId).getQuestions()[questionI].getAlternatives()[altI].getText();
            out[1] = quizzes.get(quizId).getQuestions()[questionI].getAlternatives()[altI].isCorrect();
            return out;
        } else {
            throw new javax.ws.rs.NotFoundException();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }
}
