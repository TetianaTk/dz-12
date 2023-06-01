/*
Переписати тести для класів Man та Woman із домашнього заняття до лекції 19, використовуючи провайдери даних.
 */

package org.example;

import marriage.Man;
import marriage.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTest {

  @Test(groups = "getter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void getFirstNameTest(Woman woman, String firstName){
    Assert.assertEquals(woman.getFirstName(), firstName);
  }

  @Test(groups = "getter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void getLastNameTest(Woman woman, String lastName){
    Assert.assertEquals(woman.getLastName(), lastName);
  }

  @Test(groups = "getter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void getAgeTest(Woman woman, int age){
    Assert.assertEquals(woman.getAge(), age);
  }

  @Test(groups = "setter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void setFirstNameTest(Woman woman, String firstName){
    woman.setFirstName(firstName);
    Assert.assertEquals(woman.getFirstName(), firstName);
  }

  @Test(groups = "setter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void setLastNameTest(Woman woman, String lastName){
    woman.setLastName(lastName);
    Assert.assertEquals(woman.getLastName(), lastName);
  }

  @Test(groups = "setter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void setAgeTest(Woman woman, int age){
    woman.setAge(age);
    Assert.assertEquals(woman.getAge(), age);
  }

  @Test(dataProviderClass = MarriageDataProvider.class, dataProvider = "woman get/set")
  public void isRetiredTest(Woman woman, boolean isRetired){
    Assert.assertEquals(woman.isRetired(), isRetired);
  }

  @Test(dataProviderClass = MarriageDataProvider.class, dataProvider = "marriages")
  public void registerPartnershipTest(Man man, Woman woman){
    woman.registerPartnership(man);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(woman.isMarried());
    softAssert.assertTrue(woman.getPartnerName().contains(man.toString()));
    softAssert.assertAll();
  }

  @Test(dataProviderClass = MarriageDataProvider.class, dataProvider = "woman divorces")
  public void deregisterPartnershipTest(Woman woman){
    woman.deregisterPartnership(true);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertFalse(woman.isMarried());
    softAssert.assertEquals(woman.getPartnerName(), "not married");
    softAssert.assertEquals(woman.getLastName(), woman.getMaidenName());
    softAssert.assertAll();
  }

}
