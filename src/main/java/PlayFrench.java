import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;

import java.util.Properties;

public class PlayFrench {
    public static void main(String[] args) {

        
        String sampleFrenchText = "Un chat, ça aime les souris !";
        Annotation frenchAnnotation = new Annotation(sampleFrenchText);
        Properties frenchProperties = StringUtils.argsToProperties("-props", "StanfordCoreNLP-french.properties");
        
        StanfordCoreNLP pipeline = new StanfordCoreNLP(frenchProperties);
        pipeline.annotate(frenchAnnotation);

        for (CoreMap sentenceCoreMap : frenchAnnotation.get(CoreAnnotations.SentencesAnnotation.class)) {
//            Tree sentenceTree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
//            System.out.println(sentenceTree);
            Sentence sentence = new Sentence(sentenceCoreMap);

            System.out.println("words : " + sentence.words().size() + ", lemmas : " + sentence.lemmas());

            System.out.println("The second word of the sentence '" + sentence + "' is " + sentence.word(1));
            // When we ask for the lemma, it will load and run the part of speech tagger
            System.out.println("The third lemma of the sentence '" + sentence + "' is " + sentence.lemma(2));
            // When we ask for the parse, it will load and run the parser
            System.out.println("The parse of the sentence '" + sentence + "' is " + sentence.parse());
        }

    }
}
