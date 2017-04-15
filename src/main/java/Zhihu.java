import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/6.
 */
public class Zhihu {
    private String question;
    private String url;
    private String questionDescription;

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    private ArrayList<String> answers;
    public Zhihu() {
        this.question = "";
        this.url = "";
        this.answers = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "问题："+question+"\r\n"+"问题描述："+questionDescription+"\r\n"+"问题链接："+url+"\r\n"+"答案："+answers+"\r\n";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
    public String writeToString(){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("问题："+question+"\r\n"+"问题描述："+questionDescription+"\r\n"+"问题链接："+url+"\r\n");
        for (String s:answers
             ) {
            stringBuffer.append("答案: "+s+"\r\n\r\n");
        }
        String out = stringBuffer.toString();
        out=out.replaceAll("<br>","\r\n");
        out=out.replaceAll("<(.*?)>","");
        return out;
    }
}
