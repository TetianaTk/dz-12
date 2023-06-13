package org.example;

import java.lang.reflect.Method;
import marriage.Man;
import marriage.Woman;
import org.testng.annotations.DataProvider;

public class MarriageDataProvider {

  @DataProvider(name = "marriages")
  public Object[][] generateMarriage(){
    return new Object[][] {
        {
            new Man("Robert", "Plant", 64, null),
            new Woman("Maureen", "Wilson", 61, null)
        },
        {
            new Man("Paul", "McCartney", 70, null),
            new Woman("Linda", "Eastman", 65, null)
        }
    };
  }

  @DataProvider(name = "man divorces")
  public Object[] generateManDivorces() {
    return new Object[]{
        new Man("Robert", "Plant", 64,
            new Woman("Maureen", "Wilson", 61, null)),
        new Man("Paul", "McCartney", 70,
            new Woman("Linda", "Eastman", 65, null))
    };
  }

  @DataProvider(name = "woman divorces")
  public Object[] generateWomanDivorces() {
    return new Object[]{
        new Woman("Maureen", "Wilson", 61,
            new Man("Robert", "Plant", 64, null)),
        new Woman("Linda", "Eastman", 65,
            new Man("Paul", "McCartney", 70, null))
    };
  }

  @DataProvider(name = "man get/set")
  public Object[][] generateManSets(Method method){
    Man man1 = new Man("Robert", "Plant", 64, null);
    Man man2 = new Man("Paul", "McCartney", 70, null);
    switch (method.getName()){
      case "getFirstNameTest": return new Object[][]{{man1, "Robert"},{man2, "Paul"}};
      case "getLastNameTest": return new Object[][]{{man1, "Plant"},{man2, "McCartney"}};
      case "getAgeTest": return new Object[][]{{man1, 64},{man2, 70}};
      case "setFirstNameTest":
      case "setLastNameTest":  return new Object[][]{{man1, "Dou"},{man2, "Foo"}};
      case "setAgeTest": return new Object[][]{{man1, 32},{man2, 35}};
      case "isRetiredTest": return new Object[][]{{man1, false},{man2, true}};
      default: return null;
    }
  }

  @DataProvider(name = "woman get/set")
  public Object[][] generateWomanSets(Method method){
    Woman woman1 = new Woman("Maureen", "Wilson", 59, null);
    Woman woman2 = new Woman("Linda", "Eastman", 65, null);
    switch (method.getName()){
      case "getFirstNameTest": return new Object[][]{{woman1, "Maureen"},{woman2, "Linda"}};
      case "getLastNameTest": return new Object[][]{{woman1, "Wilson"},{woman2, "Eastman"}};
      case "getAgeTest": return new Object[][]{{woman1, 59},{woman2, 65}};
      case "setFirstNameTest":
      case "setLastNameTest":  return new Object[][]{{woman1, "Dou"},{woman2, "Foo"}};
      case "setAgeTest": return new Object[][]{{woman1, 32},{woman2, 35}};
      case "isRetiredTest": return new Object[][]{{woman1, false},{woman2, true}};
      default: return null;
    }
  }

}
