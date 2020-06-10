# QuestionAnswers

Application cn be started from Application.java.
Application context needs to be passed in all layers.


Layer:

1) contoller - this is called by user. it takes input like paragraph and question file.
2) service -  this layer has business logic . it will call all code flow steps.
3) model - it has Question pojo class. it holds question , matching sentence index, answer.
4) exception - custom exception to throw exception with correct message.
5) Tokenizer - create token for sentence and question
6) filter - all filter apply on sentence and question
7) util - util methods.like percentage calculation.

Code flow :

1) sentence proceesing
  a. apply fllter to sentence( like lower case conversion , stop words removal )
  b. create keywords.
2) question processing 
  a. apply filter to question( question mark removal , Wh words removal)
  b. create keywords
3) calculate percentage match between senetnce and question
  a. match each question keywords with every sentence. Pick up the best match.
  b. match needs to be caluclated based on total no of keyword in question and no of matchd words.
4) Answer procesing.
  a. load sentence which has matching keywords.
  b. remove all matched keywords from sentence.
  c. apply filter like remove Adverb till comma which is usual pattern in english language.
  d. update Question class.
5) Display answers.

Test case : 

Cover almost all scenario.



