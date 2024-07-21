package org.isel.shs.api.dto.`in`


interface SoftwareId {
    val id: String
    val confidence: String
    val url: String
}

data class Package(override val id: String, override val confidence: String, override val url: String) : SoftwareId

data class Software(
    val id: String,
    val versionStartIncluding: String?,
    val versionEndExcluding: String?,
    val vulnerabilityIdMatched: String?
)
data class VulnerableSoftware(
    val software: Software
)

data class CommonPlatformEvidence(override val id: String, override val confidence: String, override val url: String) :
    SoftwareId

data class CommonVulnerabilityScoringSystem(
    val baseScore: Double?,
    val attackVector: String?,
    val attackComplexity: String?,
    val privilegesRequired: String?,
    val userInteraction: String?,
    val scope: String?,
    val confidentialityImpact: String?,
    val integrityImpact: String?,
    val availabilityImpact: String?,
    val baseSeverity: String?,
    val exploitabilityScore: Float?,
    val impactScore: Float?,
    val version: Float?
)

data class CommonVulnerabilityEvidence(
    val source: String,
    val name: String,
    val severity: String,
    val cvssv3: CommonVulnerabilityScoringSystem,
    val cwes: List<String>,
    val description: String,
    val notes: String,
    val vulnerableSoftware: List<VulnerableSoftware>
)


//data class TestObeject2(
//    val vendorEvidence : List<String?>,
//    val productEvidence : List<String?>,
//    val versionEvidence : List<String?>
//
//)
//data class TestObject(
//    val isVirtual : Boolean,
//    val fileName: String,
//    val filePath : String,
//    val md5 : String,
//    val sha1 : String,
//    val sha256: String,
//    val evidenceCollected : TestObeject2
//)
data class DependencyObject(
    val fileName: String,
    val description: String?,
    val license: String?,
    val packages: List<Package>?,
    val vulnerabilityIds: List<CommonPlatformEvidence>?,
    val vulnerabilities: List<CommonVulnerabilityEvidence>?

)