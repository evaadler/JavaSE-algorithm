//package mockito.cookbook;
//
//import datastructure.stack.Person;
//
///**
// * PersonProcessor
// *
// * @author Alicia
// * @description
// * @date 2020/8/18
// */
//public class PersonProcessor {
//
//    private final PersonSaver personSaver;
//
//    public PersonProcessor(PersonSaver personSaver){
//        this.personSaver = personSaver;
//    }
//
//    public boolean process(Person person){
//        try {
//            personSaver.savePerson(person);
//            return true;
//        }catch (FailedToSavedPersonDataException e){
//            System.out.printf("Exception occured while trying save person data [%s]%n", e);
//            return false;
//        }
//    }
//
//
//}
