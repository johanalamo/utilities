
publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            artifact(dokkaJar)
        }
        create<MavenPublication>("maven") {
            groupId = "com.alamo.utilities"
            artifactId = "Matrix"
            version = "1.1"

            from(components["java"])
        }
    }
    repositories {
        maven {
          url = uri("$buildDir/repository")
        }

    }
}
