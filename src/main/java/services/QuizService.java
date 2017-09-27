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
//        if(quizzes.size() < 1){
//            Quiz q = new Quiz();
//            q.setId("1");
//            q.setName("Testname");
//            q.setStartTime(new Date());
//            Question[] que = new Question[2];
//            que[0] = new Question();
//            que[1] = new Question();
//            que[0].setQuestion("Test1");
//            que[1].setQuestion("Dette er et testspørsmpl?");
//            Alternative[] alt1 = new Alternative[2];
//            alt1[0] = new Alternative();
//            alt1[1] = new Alternative();
//            alt1[2] = new Alternative();
//            alt1[0].setText("1");
//            alt1[1].setText("2");
//            alt1[2].setText("3");
//            que[0].setAlternatives(alt1);
//            Alternative[] alt2 = {new Alternative("Dette er alternativ 1", true),
//                    new Alternative("Et annet alternativ", false),
//                    new Alternative("Siste alternativ", false)};
//            que[1].setAlternatives(alt2);
//            q.setQuestions(que);

//            quizzes.put(q.getId(),q);

//            System.out.println(quizzes.size());

//            Quiz q2 = new Quiz();
//            q2.setId("2");
//            q2.setName("Testname 2");
//            q2.setStartTime(new Date());
//            Question[] que2 = new Question[2];
//            que2[0] = new Question();
//            que2[1] = new Question();
//            que2[0].setQuestion("Her har du et spørsmål");
//            que2[1].setQuestion("Dette er et annerledes spørsmål");
////            Alternative[] alt3 = {new Alternative("Meg", true),
////                    new Alternative("Deg", false),
////                    new Alternative("alle", false)};
////            que2[0].setAlternatives(alt3);
////            Alternative[] alt4 = {new Alternative("Dette er alternativ 1", true),
////                    new Alternative("Et annet alternativ", false),
////                    new Alternative("Siste alternativ", false)};
////            que2[1].setAlternatives(alt4);
//            q2.setQuestions(que2);

//            quizzes.put(q2.getId(),q2);
//        }
    }

    @POST
    @Path("/setCurrentQuestion/{questionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setCurrentQuestion(@PathParam("questionId") int q){
        currentQuestion = q;
    }

    @POST
    @Path("/incCurrentQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    public void incCurrentQuestion(){
        currentQuestion++;
    }

    @POST
    @Path("/setQuiz/{quizId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setQuiz(@PathParam("quizId") String id){ quizId = id; }

    @POST
    @Path("/nyQuiz")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz q){
        q.setId("" + (quizzes.size() + 1));
        q.setStartTime(new Date());
        quizzes.put(q.getId(), q);
    }

    @POST
    @Path("/scoreInc")
    @Consumes(MediaType.APPLICATION_JSON)
    public void scoreInc(){
        quizzes.get(quizId).setScore(1);
    }

    @GET
    @Path("/lastQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean lastQuestion(){
        return currentQuestion == quizzes.get(quizId).getQuestions().length;
    }

    @GET
    @Path("/getScore")
    @Produces(MediaType.APPLICATION_JSON)
    public int getScore(){
        System.out.println(quizzes.get(quizId).getScore());
        return quizzes.get(quizId).getScore();
    }


    @GET
    @Path("/getCurrentQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public int getCurrentQuestion(){
        return currentQuestion;
    }

    @GET
    @Path("/getQuestionText")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSpm(){
        return quizzes.
                get(quizId).
                getQuestions()[currentQuestion].
                getQuestion();
    }

    @GET
    @Path("/getCurrentAlternatives/{altI}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getAlternative(
            @PathParam("altI") int altI){
        if(quizzes.containsKey(quizId)){
            String[] out = new String[2];
            out[0] = quizzes.
                    get(quizId).
                    getQuestions()[currentQuestion].
                    getAlternatives()[altI].
                    getText();
            out[1] = quizzes.get(quizId).getQuestions()[currentQuestion].getAlternatives()[altI].isCorrect();
            return out;
        } else {
            throw new javax.ws.rs.NotFoundException();
        }
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
    @Path("/getQuizList")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes() {
        Map<String,Quiz> out = new HashMap<String,Quiz>();
        for(int i = 1; i <= quizzes.size(); i++){

        }
        return quizzes.values();
    }
}
