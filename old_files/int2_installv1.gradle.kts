//se debe traducir a kotlin DSL
//extraido de
//   https://raw.githubusercontent.com/nuuneoi/JCenter/master/installv1.gradle
// y la url del tutorial para esta publicacion es:
//   http://codictados.com/publicar-libreria-de-android/

apply plugin: 'com.github.dcendents.android-maven'

group = publishedGroupId                               // Maven Group ID for the artifact

install {
    repositories.mavenInstaller {
        // This generates POM.xml with proper parameters
        pom {
            project {
                packaging 'aar'
                groupId publishedGroupId
                artifactId artifact

                // Add your description here
                name libraryName
                description libraryDescription
                url siteUrl

                // Set your license
                licenses {
                    license {
                        name licenseName
                        url licenseUrl
                    }
                }
                developers {
                    developer {
                        id developerId
                        name developerName
                        email developerEmail
                    }
                }
                scm {
                    connection gitUrl
                    developerConnection gitUrl
                    url siteUrl

                }
            }
        }
    }
}
