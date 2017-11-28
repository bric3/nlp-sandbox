import edu.stanford.nlp.simple.Document;

import java.util.Properties;

public class Play1 {
    public static void main(String[] args) {
//        Document document = new Document("I need to code");
//        Document document = new Document("J'ai besoin de coder");

        new Document("add your text here! It can contain multiple sentences. I was running late.")
                .sentences()
                .forEach(
                        sentence -> {
                            sentence.tokens()
                                    .stream()
                                    .map(token -> token.originalText() + ":" + token.tag() + ":" + token.nerTag())
                                    .forEach(System.out::println);

                            System.out.println("words : " + sentence.words().size() + ", lemmas : " + sentence.lemmas());

                            System.out.println("The second word of the sentence '" + sentence + "' is " + sentence.word(1));
                            // When we ask for the lemma, it will load and run the part of speech tagger
                            System.out.println("The third lemma of the sentence '" + sentence + "' is " + sentence.lemma(2));
                            // When we ask for the parse, it will load and run the parser
                            System.out.println("The parse of the sentence '" + sentence + "' is " + sentence.parse());
                        });

        new Document(french(), "Un chat, ça aime les souris !")
                .sentences()
                .forEach(
                        sentence -> {
                            sentence.tokens()
                                    .stream()
                                    .map(token -> token.originalText() + ":" + token.tag() + ":" + token.nerTag())
                                    .forEach(System.out::println);

                            System.out.println("words : " + sentence.words().size() + ", lemmas : " + sentence.lemmas());

                            System.out.println("The second word of the sentence '" + sentence + "' is " + sentence.word(1));
                            // When we ask for the lemma, it will load and run the part of speech tagger
                            System.out.println("The third lemma of the sentence '" + sentence + "' is " + sentence.lemma(2));
                            // When we ask for the parse, it will load and run the parser
                            System.out.println("The parse of the sentence '" + sentence + "' is " + sentence.parse());
                        });

    }

    private static Properties french() {
        Properties properties = new Properties();
        properties.put("language", "french");
        return properties;
    }
}
