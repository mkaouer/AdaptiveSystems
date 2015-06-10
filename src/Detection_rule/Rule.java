package Detection_rule;
import java.lang.*;

public class Rule
{ 
    public MetaModel src;
    public MetaModel src2;
    public MetaModel trg;
    
    public String rule_text ;
    
    public Rule()
    {
       src = new MetaModel();
       src2 = new MetaModel();
       trg = new MetaModel();
       rule_text = new String();
    }
    
    public void print_rule()
    {
        String temp = new String("IF (");
        temp = temp.concat(src.metamodel_text);
        temp = temp.concat(") and ( ");
        temp = temp.concat(src2.metamodel_text1);
        temp = temp.concat(" ) THEN ( ");
        temp = temp.concat(trg.metamodel_text2);
        temp = temp.concat(" )");
        rule_text = temp ;
    }
    
    
}


