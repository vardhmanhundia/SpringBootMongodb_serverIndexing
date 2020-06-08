package com.kaibur.mongodb.serverindex.serverindex;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServerRepository repository;
    @Autowired
    private MongoOperations mongoOps;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //for fetching all the servers in the database
    @GetMapping("/")
    public List<Server> getServers() {
        return repository.findAll();
    }

    //for fetching server with serverId in the database
    @GetMapping("/{id}")
    public Server getServer(@PathVariable long id) {
         Optional<Server> server = repository.findById(id);
         if(server.isPresent()){
            return server.get();
         }else
         {
             throw new ApiRequestException("No server with id found");
         }
    }
    //for fetching all the servers with serverName having name attribute in the string from the database
    @GetMapping("/search/{name}")
    public List<Server> searchServer(@PathVariable String name) {

        Query query = new Query();
        String string  = String.format(".*%s.*",name);
        query.addCriteria(Criteria.where("serverName").regex( string,"i"));
        List<Server> servers = mongoOps.find(query, Server.class);

        if(servers.size()==0) {
            throw new ApiRequestException("No such server available");
        }else{
            return servers;
        }
    }
    //for deleting server with specific serverId from the database
    @DeleteMapping("/{id}")
    public String deleteServer(@PathVariable long id) {
        repository.deleteById(id);
        return "Server Deleted with id: "+ id;
    }

    //for deleting servers with List of specific server Ids from the database
    @DeleteMapping("/deleteMultiple")
    public String deleteMultipleServers(@RequestBody List<Long> ids) {
        for(Long id: ids){
            repository.deleteById(id);
        }
        return "Listed servers were been Deleted";
    }

    //for adding a server to the database
    @PostMapping("/add")
    public String addServer(@RequestBody Server server) {
        server.setId(sequenceGeneratorService.generatedSequence(server.SEQUENCE_NAME));
        repository.insert(server);
        return "Added server with id: " + server.getId();
    }

    //for adding multiple servers to the database
    @PostMapping("/addMultiple")
    public String addMultipleServer(@RequestBody List<Server> servers) {
        for(Server i:servers){
            i.setId(sequenceGeneratorService.generatedSequence(i.SEQUENCE_NAME));
            repository.insert(i);
        }
        return "Added elements to the server ";
    }

    //for updating server with serverId in the database
	@PutMapping("/update")
	public String updateServer(@RequestBody Server server) {
        repository.save(server);
        return "The server data with id"+ server.getId();
    }

    //for updating multiple servers in the database
    @PutMapping("/updateMultiple")
    public String updateMultipleServer(@RequestBody List<Server> servers) {
        for(Server i:servers) {
            repository.save(i);
        }
        return "The servers were updated successfully";
    }
}
