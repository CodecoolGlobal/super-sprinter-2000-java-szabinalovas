# Super Sprinter 2000

## Story

In this assignment you'll build a simple web application that might help
teams to track their progress during a project. You'll learn about agile
development later so let us summarize some concepts here:

- **User story description**: a natural language description/story from
  the perspective of a user of the system. Example: "As a \<persona\>, I
  want \<what?\> so that \<why?\>"
- **Acceptance Criteria**: a set of statements, each with a clear
  pass/fail result, that specify both functional and non-functional
  requirements.
- **Business value**: a numerical value to represent the importance of
  the User Story for the so called business (actually the customer).
- **Estimation**: Summary of the expected amount of work in all tasks
  collected to achieve User Story.
- **Status**: Current state of the User Story's development cycle.

Your system should be able to list, create, and update User Stories.

## What are you going to learn?

 - create a Spring project
 - use HTML and the Thymeleaf templating engine
 - map web requests
 - form validation
 - persist data using Spring JDBC

## Tasks

1. Create a `UserStory` class to model a `UserStory` object in the `model layer`. A User Story should have the following properties:
  - `Story Title`: String, minimum 5 characters long, maximum 100, required
  - `User Story`: String, max 400 characters long, required
  - `Acceptance Criteria`: max 400 characters long, required
  - `Business value`: number, a range between 0.5 and 40, divisible by 0.5
  - `Status`: maximum 20 characters long
    - There is a `UserStory` class in the `model layer`.

2. Create a `schema.sql` in the `resources` folder to describe how the User Stories should be persisted in the database. The table described in the `schema.sql` should contain the restrictions for the string fields described above, also, where no else rule applies, set the length at 500. After having a schema, create a `data.sql` in the `resources` folder to fill this database with one initial entry.
    - The `resources` folder contains a `schema.sql`, where the database and table creation is described.
    - After executing the `schema.sql`, a table is created where the restrictions for maximum length on `varchar` types apply.
    - The  `resources` folder contains a `data.sql`, where one initial entry is inserted.
    - After executing the `data.sql` an example User Story is created.

3. Create a `UserStoryDAO` interface in the `dao layer`, with methods for creating, reading, and updating User Stories.
    - The student has a `UserStoryDAO` interface in the `dao layer`.
    - The `UserStoryDAO` interface has methods for creating a User Story, get one by ID, list all, and update by ID.

4. Create a `UserStoryDaoJdbcImpl` class where all methods of the `UserStoryDAO` are implemented using `JDBC`. Create a `UserStoryMapper` class, where the `RowMapper<UserStory>` interface is implemented, to help serializing.
    - All methods of `UserStoryDAO` interface are implemented in the `UserStoryDaoJdbcImpl` class.
    - A `RowMapper` with the `UserStory` type is implemented.

5. Create a `UserStoryService` in the `service layer`. The service class should be able to create, read, and update User Stories, and persist them through the `UserStoryDAO`.
    - The `UserStoryService` has methods for creating, reading, and updating User Stories by using the `UserStoryDAO`.

6. Create a `UserStoryController`class in the `controller layer` for handling requests.
    - Student has a `UserStoryController`class in the `controller layer`.

7. Create an `index.html` in the `resources/templates` folder, use Thymeleaf for making variables. The opening page of the website (`/`) should show all data of the saved User Stories, using the `index`. The page has an HTML `<table>` element containing all the data. The columns in the `<table>` are: "Id", "Story Title", "User Story", "Acceptance Criteria", "Business Value", "Estimation", "Status". Create a link over the HTML table that leads to the `/story` page named "Add User Story". Create a link at the end of each table row, where the given User Story can be updated. It should lead to the `/story/id` page The page should follow this basic design, don't use any CSS ![Super Sprinter 3000 - List.png](https://learn.code.cool/media/web-python/super-sprinter-3000-list.png)
    - The student has an `index.html`, including `Thymeleaf` variables.
    - The opening page of the website (`/`) shows all data of the saved User Stories.
    - The data on the page is rendered in a `<table>` element.
    - The columns are "Id", "Story Title", "User Story", "Acceptance Criteria", "Business Value", "Estimation", "Status".
    - There is an "Add User Story" link over the HTML table that leads to the `/story` page.
    - At the end of each table row, there is a link, where the given User Story can be updated, leading to the `/story/id` page.

8. The page `/story` shows an empty web `form`, with an input field for all the `User Story` fields except for `id` and `status`. Before sending the `form`, you should validate it by applying __all__ rules described in the `Model User Stories` task. Create an `Add new User Story` button. After clicking this submit button, the form submits the data that gets saved with a new unique `id` generated. The page should follow this basic design: ![Super Sprinter 3000 - Add.png](https://learn.code.cool/media/web-python/super-sprinter-3000-add.png)
    - The `/story` page shows an empty web form.
    - The form has an input field for all the `User Story` fields except for `id` and `status`.
    - The form data is validated by applying all defined rules.
    - When a new User Story is saved, a unique `id` is generated for it.

9. Create a page for updating User Stories. The page `/story/id` should use the same web form as on the `Add new` page. When updating a `User Story`, the form should be filled with data of the given User Story. The form should have an input field for all `User Story` fields, except `id`. Create a dropdown value list for the `Status` field. The options are: `planning`, `todo`, `in progress`, `review`, `done`. By default, the value of the `dropdown menu` should be the current `Status` of the `User Story`. Create a button `Update User Story` to submit changes to the existing `User Story`. The page follows this basic design: ![Super Sprinter 3000 - Update.png](https://learn.code.cool/media/web-python/super-sprinter-3000-update.png)
    - There is a page at `/story/id` for updating existing User Stories.
    - The update page uses the same web form as on the `Add new` page.
    - The form has an input field for `Story Title`, `User Story`, `Acceptance Criteria`, `Business value`, `Estimation`.
    - The form has a dropdown menu for `Status`, with options `planning`, `todo`, `in progress`, `review`, `done`.
    - The current status of the User Story is selected by default.
    - Clicking the "Update User Story" button updates the existing entry and does not create a new one.

## General requirements

None

## Hints

- You **don't** have to use CSS!
- Use the same form template file for both adding and updating the User Stories.
- You can define in the `<input>` tag to contain a `min="100"` `max="1500"` `step="100"` properties. In this example, the `numerical input` needs to be `greater than 100`,  `less than 1500`, and `divisible by 100`.
- You can use the `@NotBlank(message = "This field must not be empty")` annotation, for marking, that the annotated element must not be null and must contain at least one non-whitespace character
- You can use the `@Size(min = 5, max = 50, message = "String length should remain between 5 and 50 characters")` for marking that the annotated element size must be between the specified boundaries (included).
 - You can use the `@Range(min = 100, max = 1500, message = "This number should be between 100 and 1500")`. The annotated element has to be in the appropriate range. Can be used on numeric values or string representation of the numeric value.
- By using `@DecimalMin("0.5")` (similar to `@DecimalMax("40.0")`) you can mark, that the annotated element must be a number whose value must be higher or equal to the specified minimum (or lower or equal to the specified maximum by `@DecimalMax()`).


## Background materials

- <i class="far fa-book-open"></i> [Spring shrine of knowledge](https://spring.io/guides)
- <i class="far fa-book-open"></i> [Spring Quickstart Guide](https://spring.io/quickstart)
- <i class="far fa-book-open"></i> [Introduction to Thymeleaf](https://www.baeldung.com/thymeleaf-in-spring-mvc)
- [Spring Boot App with Thymeleaf](https://www.baeldung.com/spring-boot-crud-thymeleaf)
- [How to use Spring JdbcTemplate](https://yashodgayashan.medium.com/how-to-use-spring-jdbctemplate-dec9e4476eaa)
- <i class="far fa-camera"></i> [Spring JDBC Template Tutorial](https://youtube.com/watch?v=0uLqdBpYAVA)
