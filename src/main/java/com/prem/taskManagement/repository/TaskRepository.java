package com.prem.taskManagement.repository;

import com.prem.taskManagement.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Tasks, Long> {

    // Saves a new entity or updates an existing entity.
    // Returns the saved entity.
    // save(S entity)

    // Saves all entities in the given collection.
    // Returns the saved entities.
    // saveAll(Iterable<S> entities)

    // Finds an entity by its primary key.
    // Returns Optional.empty() if no entity exists with that ID.
    // findById(ID id)

    // Returns true if an entity with the given ID exists.
    // existsById(ID id)

    // Retrieves all entities.
    // findAll()

    // Retrieves all entities whose IDs are in the given collection.
    // findAllById(Iterable<ID> ids)

    // Returns the total number of entities.
    // count()

    // Deletes the entity with the given ID, if it exists.
    // deleteById(ID id)

    // Deletes the given entity.
    // delete(T entity)

    // Deletes all entities in the given collection.
    // deleteAll(Iterable<? extends T> entities)

    // Deletes all entities.
    // deleteAll()

    // Deletes all entities by iterating through them.
    // Generally less efficient than a bulk delete query.
    // deleteAll(Iterable<? extends T> entities)

    // Flushes all pending changes to the database.
    // flush()

    // Saves an entity and flushes changes immediately.
    // Returns the saved entity.
    // saveAndFlush(S entity)

    // Saves all entities and flushes changes immediately.
    // Returns the saved entities.
    // saveAllAndFlush(Iterable<S> entities)

    // Deletes entities in a batch operation.
    // deleteAllInBatch()

    // Deletes the given entities in a batch operation.
    // deleteAllInBatch(Iterable<T> entities)

    // Deletes entities with the specified IDs in a batch operation.
    // deleteAllByIdInBatch(Iterable<ID> ids)

    // Returns a reference to an entity by ID.
    // May defer database access until the entity is accessed.
    // getReferenceById(ID id)

    // Returns the entity class managed by this repository.
    // getDomainClass()

    // Returns the repository's entity information.
    // getEntityInformation()

    /*
    You don't implement save(), findAll(), or findById().
    At application startup, Spring Data JPA creates a repository
    implementation for you. That implementation uses JPA and Hibernate
    to perform the database operations.


    Can we add our own methods?
    Yes! Suppose you want to find all completed tasks. You can add a method to your repository:
    public interface TaskRepository
            extends JpaRepository<Tasks, Long> {

        List<Tasks> findByCompleted(boolean completed);
    }


    Spring Data JPA can derive the query from the method name.
    You don't need to write the SQL yourself.

    You could then call:
    taskRepository.findByCompleted(true);


    to retrieve completed tasks.
     */
}