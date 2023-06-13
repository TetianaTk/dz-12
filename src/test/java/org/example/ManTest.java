/*
Переписати тести для класів Man та Woman із домашнього заняття до лекції 19, використовуючи провайдери даних.
 */

package org.example;

import marriage.Man;
import marriage.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManTest {

  @Test(groups = "getter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void getFirstNameTest(Man man, String firstName){
    Assert.assertEquals(man.getFirstName(), firstName);
  }

  @Test(groups = "getter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void getLastNameTest(Man man, String lastName){
    Assert.assertEquals(man.getLastName(), lastName);
  }

  @Test(groups = "getter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void getAgeTest(Man man, int age){
    Assert.assertEquals(man.getAge(), age);
  }

  @Test(groups = "setter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void setFirstNameTest(Man man, String firstName){
    man.setFirstName(firstName);
    Assert.assertEquals(man.getFirstName(), firstName);
  }

  @Test(groups = "setter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void setLastNameTest(Man man, String lastName){
    man.setLastName(lastName);
    Assert.assertEquals(man.getLastName(), lastName);
  }

  @Test(groups = "setter_test",
      dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void setAgeTest(Man man, int age){
    man.setAge(age);
    Assert.assertEquals(man.getAge(), age);
  }

  @Test(dataProviderClass = MarriageDataProvider.class, dataProvider = "man get/set")
  public void isRetiredTest(Man man, boolean isRetired){
    Assert.assertEquals(man.isRetired(), isRetired);
  }

  @Test(dataProviderClass = MarriageDataProvider.class, dataProvider = "marriages")
  public void registerPartnershipTest(Man man, Woman woman){
    man.registerPartnership(woman);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(man.isMarried());
    softAssert.assertTrue(man.getPartnerName().contains(woman.toString()));
    softAssert.assertAll();
  }

  @Test(dataProviderClass = MarriageDataProvider.class, dataProvider = "man divorces")
  public void deregisterPartnershipTest(Man man){
    man.deregisterPartnership(false);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertFalse(man.isMarried());
    softAssert.assertEquals(man.getPartnerName(), "not married");
    softAssert.assertAll();
  }

}
