//se debe traducir a kotlin DSL
//extraido de
//   https://raw.githubusercontent.com/nuuneoi/JCenter/master/bintrayv1.gradle
// y la url del tutorial para esta publicacion es:
//   http://codictados.com/publicar-libreria-de-android/


plugins {
    id("com.jfrog.bintray")
}

//traduciendo a kotlin DSL, voy por aqui.
//ya está en el build.gradle.kts
//version = libraryVersion

//println("flagflag: " + version)

if (project.hasProperty("android")) { // Android libraries
  val sourcesJar by tasks.registering(Jar::class) {
      classifier = "sources"
      from(sourceSets.main.get().allSource)
  }
  //      from android.sourceSets.main.java.srcDirs
  tasks.dokka {
      outputFormat = "html"
      outputDirectory = "$buildDir/javadoc"
  }
} else { // Java libraries
  val sourcesJar by tasks.registering(Jar::class) {
      classifier = "sources"
      from(sourceSets.main.get().allSource)
  }
//        from sourceSets.main.allSource
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    classifier = "javadoc"
    from(tasks.dokka)
}

artifacts {
    archives(javadocJar)
    archives(sourcesJar)
}

// Bintray
var properties:Properties = Properties()
properties.load(project.rootProject.file('local.properties').newDataInputStream())

bintray {
    user = properties.getProperty("bintray.user")
    key = properties.getProperty("bintray.apikey")

    configurations = ['archives']
    pkg {
        repo = bintrayRepo
        name = bintrayName
        desc = libraryDescription
        websiteUrl = siteUrl
        vcsUrl = gitUrl
        licenses = allLicenses
        publish = true
        publicDownloadNumbers = true
        version {
            desc = libraryDescription
            gpg {
                sign = true //Determines whether to GPG sign the files. The default is false
                passphrase = properties.getProperty("bintray.gpg.password")
                //Optional. The passphrase for GPG signing'
            }
        }
    }
}
