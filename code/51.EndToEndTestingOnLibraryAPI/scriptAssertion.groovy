def response = messageExchange.response.responseContent
boolean found = false
def json = new JsonSlurper().parseText(response)

log.info json.size()

// Get a test suite property, ISBN
def isbn = messageExchange.modelItem.testStep.testCase.testSuite.getPropertyValue( "ISBN")

for (i=0; i < json.size(); i++) {
	if (json[i].isbn == isbn) {
		found = true
	}
}

assert found == true