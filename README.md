Android-Kotlin
==============

This is a POC project that I am using to test out Kotlin for android development. As a Mobile Developer for Android as well as iOS, I have dabbled with both Java and Swift along with Objective-C. For the following reasons however, I decided to give Kotlin a try. And I wanted to document my findings along the way.

### Findings:
- Null check boilerplates are a lot reduced.
- Business logic translates a lot easier between Swift and Kotlin due to the use of optionals and clojures.
- Java code is still accessible from Kotlin.
- Functional programming is natural with proper function types.

### Ease of Getting started.
The starting process was rather trivial. All I had to do was start two actions in android studio. The steps can be summarized as follows.
- Install the Kotlin pluglin from JetBrains plugins repository.
- Restart the IDE.
- Go to your main activity class to convert it to Kotlin.
- Hold Shift + CMD + A and Type "Convert JAVA file to Kotlin File" and run it.
- Hold Shift + CMD + A and Type "Configure Kotlin in Project" and run it.
- Resync gradle file which should now be converted to use Kotlin.
- As of 4/16/2019, you might have to change the auto generated kotlin version to 1.1.1 to compile the grade script. This can be done in project level build.gradle. Set the following parameter:
```
ext.kotlin_version = '1.1.1'
```
