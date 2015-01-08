import gassMap.db.Address
import gassMap.springSecurity.Role
import gassMap.springSecurity.Person
import gassMap.springSecurity.PersonRole

class BootStrap {
	
	def init = {
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
		def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
		def adminUser = Person.findByUsername('admin') ?: new Person( username: 'admin', password: 'admin', email:'admin@admin.de', enabled: true).save(failOnError: true)
		if (!adminUser.authorities.contains(adminRole)) {
			PersonRole.create(adminUser, adminRole, true)
			}
		def address = new Address(street:'arschstrasse').save(failOnError: true)
		
		//adminUser.addresses.add(address)
		}
		

    /* def init = { servletContext ->
    } */
	
    def destroy = {
    }
}
