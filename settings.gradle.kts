plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "ecommerce"
include("ecommerce-adapter")
include("ecommerce-domain")
include("ecommerce-application")
