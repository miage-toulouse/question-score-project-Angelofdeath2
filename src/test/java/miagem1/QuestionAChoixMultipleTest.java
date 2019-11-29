package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple uneQuestion;
    private List<Integer> indicesBonnesReponses;

    @Before
    public void setUp() throws Exception {
        //given : un objet de type QuestionAChoixMultiple
        List<Integer> indicesBonnesReponses = new ArrayList<Integer>();
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);
        uneQuestion = new QuestionAChoixMultiple("un énoncé",indicesBonnesReponses);
    }
    @Test
    public void testgetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = uneQuestion.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(resEnonce);
        // and : l'énoncé est bien celui fourni à la construction
        assertEquals(resEnonce, "un énoncé");
    }

    @Test
    public void testgetScoreForIndice() {
        // when un étudiant fourni l'indice correspondant à une des deux bonnes réponses
        int indiceEtudiant =1;
        // and : on demande le calcul du score
        Float resScore =uneQuestion.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 50
        assertEquals(new Float(50f),resScore);
        // when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant =3;
        resScore =uneQuestion.getScoreForIndice(indiceEtudiant);
        // then le score obtenu est 0
        assertEquals(new Float(0f),resScore);
    }
}