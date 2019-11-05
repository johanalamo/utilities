import org.gradle.jvm.tasks.Jar


//This is to generate a javadoc JAR file, and it is done with 'gradle dokkaJar'
//in the console
val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    classifier = "javadoc"
//    from(tasks.dokka)
}
