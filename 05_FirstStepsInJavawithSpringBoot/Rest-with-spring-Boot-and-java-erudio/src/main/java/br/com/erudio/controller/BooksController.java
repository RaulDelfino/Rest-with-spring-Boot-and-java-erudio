package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.services.BooksServices;
import br.com.erudio.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/books/v1")
@Tag(name= "Books", description = "EndPoints for Managing Books")
public class BooksController {
    
    @Autowired
    BooksServices services;

    @GetMapping(value = "/{id}", produces = {
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML
        })
    @Operation(
        summary = "Finds a Book", description = "Finds a Book",
        tags = {"Books"},
        responses = {
             @ApiResponse(description = "Success", responseCode = "200", 
                content = @Content(mediaType = "application/json")
                ),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        }
        
    )
    public BooksVO findById(@PathVariable Long id) {
        return services.findById(id);
    }
    
    @GetMapping(produces = {
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML
        })
     @Operation(summary = "Finds All Books",  description = "Finds All Books", 
        tags= {"Books"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200", 
                content = {
                    @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = BooksVO.class))
                    )
                }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        })
    public List<BooksVO> findAll() {
        return services.findAll();
    }

    @PostMapping(consumes =  {
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, 
        MediaType.APPLICATION_YML
    }, 
    produces = {
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML
        })
        @Operation(summary = "Adds a New Book",  description = "Adds a New Book", 
        tags= {"Books"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200", 
                content = @Content(mediaType = "application/json")
                ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public BooksVO create(@RequestBody BooksVO entity) {
        return services.create(entity);
    }

    @PutMapping(
    
    consumes =  {
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, 
        MediaType.APPLICATION_YML
    }, 
    produces = {
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML
        })
    @Operation(summary = "Updates a Book",  description = "Updated a Book", 
        tags= {"Books"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200", 
                content = @Content(mediaType = "application/json")
                ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        })     
    public BooksVO update(@RequestBody BooksVO entity) {
        return services.update(entity);
    }
    
    @DeleteMapping(value= "/{id}")
    @Operation(summary = "Deletes a Book",  description = "Deletes a Book", 
        tags= {"Books"},
        responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public void delete(@PathVariable(value = "id") Long id){
        services.delete(id);
    }
    
}
