package gassmap
import gassMap.springSecurity.Person

class ManageController {
	def springSecurityService
	
    def index() {
		Person per = springSecurityService.currentUser
		
		return [
			per:per
			]
	}
}
