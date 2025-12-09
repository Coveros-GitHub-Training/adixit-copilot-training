# Exercise 8 - GitHub Copilot Spaces

#### Duration: 30 minutes

## 🎯 Learning Objectives

By the end of this exercise, you will:
- Understand what GitHub Copilot Spaces are and their benefits
- Create and configure multiple Copilot Spaces for different purposes
- Set up Spaces with specific goals, instructions, and context
- Complete development tasks using focused AI assistance in Spaces
- Access and use Spaces from within your IDE via GitHub MCP

## 🍳 Scenario: Collaborative Development at FlavorHub

Your team at FlavorHub is working on multiple simultaneous initiatives for the application:
- A security audit to ensure the recipe upload and pantry management systems are hardened against vulnerabilities
- New documentation for the API and component architecture
- Performance optimization for recipe search and filtering
- Accessibility improvements across the application

These are complex, multi-faceted projects that benefit from focused, dedicated AI assistance with specific context and goals. Your manager has asked you to explore GitHub Copilot Spaces as a way to organize these initiatives and collaborate more effectively with AI assistance.

## 🌟 Introduction to GitHub Copilot Spaces

**GitHub Copilot Spaces** are dedicated, persistent AI workspaces where you can:
- Define specific goals and instructions for a project or initiative
- Add relevant context files, issues, and documentation
- Have focused conversations with Copilot about a particular topic
- Collaborate with team members in a shared AI context

### Spaces vs. Regular Copilot Chat:

| Feature | Regular Chat | Copilot Spaces |
|---------|--------------|----------------|
| Context | Current workspace only | Custom files, repos, issues, docs |
| Instructions | General + repo instructions | Custom instructions per Space |
| Collaboration | Individual conversations | Shared team Spaces |

---

## 🎯 Step 1: Create Your First Space - Security Analysis

In this lab, you'll create TWO different Copilot Spaces to experience how they can be tailored for different purposes. Let's start with a Security Analysis Space.

### Instructions:

1. **Navigate to Copilot Spaces:**
   - Go to [https://github.com/copilot/spaces](https://github.com/copilot/spaces)

2. **Create a new Space:**
   - Click **"Create Space"** button

3. **Configure the Security Analysis Space:**

**Purpose**: Analyze and improve the security posture of the FlavorHub application.

**Basic Settings:**

1. **Space name**: `FlavorHub - Security Assessment`
2. **Owner**: Select your username
3. **Description**: `Implement security best practices for the FlavorHub application`

**Add Instructions:**

4. Click **"Instructions"**
5. Add the following instructions:

```markdown
You are a security expert helping to analyze and improve the security posture of a Spring Boot recipe management application. Focus on:

- Recipe upload and pantry management security vulnerabilities and mitigations
- Input validation and sanitization for REST APIs
- Authentication and authorization patterns
- XSS prevention in user-generated content and HTML templates
- Secure data handling and storage
- OWASP Top 10 web application security risks
- Spring Boot specific security best practices
- Thymeleaf template security

Provide specific code examples and security recommendations that follow industry standards and OWASP guidelines. Consider both server-side and client-side security measures.
```

7. Click **"Save"**

**Add Source Files:**

8. Click **"Add sources"** → **"Add files from repositories"**
9. Add the following files from your version of this repository:
   ```
   flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java
   flavorhub/src/main/java/com/coveros/training/flavorhub/controller/UserPantryController.java
   flavorhub/src/main/resources/templates/index.html
   flavorhub/src/main/resources/application.properties
   ```

**Add Security Documentation:**

10. Click **"Add sources"** → **"Add text content"**
11. Add the following security reference:

Name: `Relevant OWASP Security Vulns`

```markdown
## OWASP Top 10 2021 - Key Security Risks for Web Applications

1. **A01 Broken Access Control** - Users can act outside of their intended permissions
2. **A02 Cryptographic Failures** - Failures related to cryptography leading to sensitive data exposure
3. **A03 Injection** - User-supplied data is not validated, filtered, or sanitized
4. **A04 Insecure Design** - Risks related to design and architectural flaws
5. **A05 Security Misconfiguration** - Missing appropriate security hardening
6. **A06 Vulnerable and Outdated Components** - Using components with known vulnerabilities
7. **A07 Identification and Authentication Failures** - Authentication and session management issues
8. **A08 Software and Data Integrity Failures** - Code and infrastructure integrity violations
9. **A09 Security Logging and Monitoring Failures** - Insufficient logging and monitoring
10. **A10 Server-Side Request Forgery** - SSRF flaws in fetching remote resources

## Spring Boot Security Headers
- Content Security Policy (CSP)
- X-Frame-Options
- X-Content-Type-Options
- Referrer-Policy
- Permissions-Policy

## Data Input Security Considerations
- Request body validation using Bean Validation
- Path variable sanitization
- Query parameter validation
- File size limits for recipe images
- SQL injection prevention with JPA
- XSS prevention in Thymeleaf templates
```

12. Click **"Save"**

✅ **Checkpoint**: You've created your first Copilot Space! You should see it in your Spaces dashboard.

---

## 🎯 Step 1b: Create Your Second Space - Documentation Hub

Now let's create a second Space focused on documentation and API design. This demonstrates how you can organize different concerns into separate, focused workspaces.

### Instructions:

1. **Return to Copilot Spaces dashboard:**
   - Go to [https://github.com/copilot/spaces](https://github.com/copilot/spaces)

2. **Create another new Space:**
   - Click **"Create Space"** button

3. **Configure the Documentation Space:**

**Purpose**: Create comprehensive documentation and API design for the FlavorHub application.

**Basic Settings:**

1. **Space name**: `FlavorHub - Documentation Hub`
2. **Owner**: Select your username
3. **Description**: `Create comprehensive documentation and API design documentation for the FlavorHub application`

**Add Instructions:**

4. Click **"Instructions"**
5. Add the following instructions:

```markdown
You are a technical documentation expert and API designer helping to create comprehensive documentation for a Spring Boot recipe management application. Focus on:

- Clear, beginner-friendly component and service documentation
- API design and endpoint specifications
- Architecture decision records (ADRs)
- Code examples and usage patterns
- JavaDoc comments for classes and methods
- README and getting started guides
- HTML template documentation for the frontend
- Performance considerations

Provide well-structured, maintainable documentation that follows industry best practices. Use clear examples and diagrams where appropriate.
```

7. Click **"Save"**

**Add Source Files:**

8. Click **"Add sources"** → **"Add files from repositories"**
9. Add the following files from your version of this repository:
   ```
   flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java
   flavorhub/src/main/java/com/coveros/training/flavorhub/service/RecipeService.java
   flavorhub/src/main/resources/templates/index.html
   README.md
   ```

**Add Documentation Templates:**

10. Click **"Add sources"** → **"Add text content"**
11. Add the following documentation template:

```markdown
## Component Documentation Template

### ComponentName

**Purpose**: [One sentence describing what this component does]

**Location**: `flavorhub/src/main/java/com/coveros/training/flavorhub/[path]/ComponentName.java`

#### Methods

| Method | Parameters | Returns | Description |
|--------|-----------|---------|-------------|
| methodName | type param | type | Description |

#### Usage Example

\`\`\`java
// Example usage
ComponentName component = new ComponentName();
component.methodName(param);
\`\`\`

#### Dependencies

- [Service 1]
- [Repository 1]

#### Related Components

- [Component 1]
- [Component 2]
```

12. Click **"Save"**

✅ **Checkpoint**: Excellent! You now have TWO specialized Copilot Spaces:
- **Security Assessment Space** - for security analysis and hardening
- **Documentation Hub Space** - for creating comprehensive documentation

You should see both spaces in your Copilot Spaces dashboard. Each Space has its own focused instructions and relevant context files.

---

## 💬 Step 2: Work Within Your Copilot Spaces

Now that your Spaces are configured, let's use them to accomplish specific goals. You'll work with each Space to see how the specialized context and instructions affect Copilot's responses.

### Instructions:

1. **Open your Security Assessment Space** from the Copilot Spaces dashboard

2. **Try these security-focused prompts:**

Create prompts to analyze the application for security vulnerabilities. Consider asking about:
- Recipe and pantry input validation
- REST API security risks
- HTML template XSS prevention
- Security headers configuration
- Security checklists based on OWASP Top 10

<details>
<summary>💡 Example Prompt</summary>

```
Analyze the RecipeController for potential security vulnerabilities. What risks should we address?
```

```
How can we implement input validation for recipe creation and pantry item additions?
```

```
Review the index.html template - are there any XSS vulnerabilities we should prevent?
```

```
What security headers should we configure in Spring Boot for this application?
```

```
Create a security checklist for the pantry management feature based on OWASP Top 10.
```
</details>

3. **Review the responses** - Notice how Copilot uses the security context and OWASP guidelines from your Space

4. **Have a multi-turn conversation** - Ask follow-up questions, request code examples, iterate on solutions

5. **Switch to your Documentation Hub Space:**
   - Return to your Spaces dashboard
   - Open the "FlavorHub - Documentation Hub" Space

6. **Try these documentation-focused prompts:**

Create prompts to generate documentation for the application. Consider asking for:
- JavaDoc comments for services and controllers
- API specifications
- Component usage guides
- Architecture decision records
- Getting started guides for developers

<details>
<summary>💡 Example Prompt</summary>

```
Generate comprehensive JavaDoc comments for the RecipeService class.
```

```
Create an API specification document for the recipe endpoints used in this application.
```

```
Write a usage guide for developers working with the RecipeController.
```

```
Generate an architecture decision record (ADR) for using Spring Boot and Thymeleaf in this project.
```

```
Create a getting started guide for new developers joining the FlavorHub project.
```
</details>

7. **Compare the experiences:**
   - Notice how each Space has different expertise based on its instructions
   - The Security Space focuses on vulnerabilities and OWASP standards
   - The Documentation Space provides clear, well-structured documentation
   - Each Space uses only the relevant files you added to its context

## 📝 Step 3: Manage and Organize Your Spaces

As you create more Spaces, organization becomes important.

### Best Practices:

1. **Use clear, descriptive names:**
   - ✅ "Recipe Upload - Security Hardening"
   - ❌ "Project A"

2. **Add comprehensive descriptions:**
   - Explain the Space's purpose
   - Include goals or success criteria
   - Note any specific constraints

3. **Keep instructions focused:**
   - Each Space should have a clear, specific purpose
   - Don't try to cover everything in one Space
   - Instructions should guide Copilot toward your specific needs

4. **Curate sources carefully:**
   - Add only relevant files and documentation
   - Too much context can dilute focus
   - Update sources as the project evolves

## 🔌 Step 4: Using Spaces from Your IDE with GitHub MCP

Now that you've created and worked with Spaces in the browser, let's integrate them into your daily workflow by accessing them directly from VS Code using the GitHub MCP server you configured in Lab 7.

### Why Use Spaces from Your IDE?

Accessing Copilot Spaces through the GitHub MCP server in your IDE provides:
- **Seamless Workflow**: No need to switch between browser and IDE
- **Context Aware**: Combine Space context with your current code
- **Faster Iteration**: Test and implement suggestions immediately
- **Integrated Experience**: Use Space expertise while actively coding

### Prerequisites:

Ensure you completed Lab 7 and have the GitHub MCP server configured in VS Code. If not, refer back to [Lab 7 - Step 2](Lab-7-Model-Context-Protocol.md#step-2-installing-the-github-mcp-server) for setup instructions.

### Step 4.1: Access Your Spaces via MCP

1. **Open VS Code** with your FlavorHub project

2. **Open GitHub Copilot Chat** in VS Code

3. **List your Copilot Spaces:**
   
   Create a prompt to list all of your Copilot Spaces.
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Show me all my Copilot Spaces
   ```
   </details>

4. **Review the list** - you should see both of your Spaces:
   - FlavorHub - Security Assessment
   - FlavorHub - Documentation Hub

### Step 4.2: Use Space Context in Your IDE

Now let's leverage your Spaces while working on code in VS Code.

#### Exercise A: Security Analysis from IDE

1. **Open the RecipeController:**
   ```
   flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java
   ```

2. **In Copilot Chat, ask for security analysis using your Space context:**

   Create a prompt in Ask mode that requests security analysis of the RecipeController using your Security Assessment Space context. Your prompt should reference the Space by name and ask for specific improvements.

   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Using my "FlavorHub - Security Assessment" Space for reference, analyze the currently open RecipeController for security vulnerabilities. What specific improvements should I make?
   ```
   </details>

3. **Review the suggestions** - Copilot should provide security-focused analysis informed by the OWASP context and instructions from your Space

4. **Ask follow-up questions** while staying in your Space context:
   
   Create a follow-up prompt asking for specific code recommendations based on the Security Assessment Space.
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Based on the Security Assessment Space, what input validation code should I add to this controller?
   ```
   </details>

#### Exercise B: Generate Documentation from IDE

1. **Open the RecipeService:**
   ```
   flavorhub/src/main/java/com/coveros/training/flavorhub/service/RecipeService.java
   ```

2. **Request documentation using your Documentation Hub Space:**

   Create a prompt in Agent mode that requests JavaDoc comments for the RecipeService using your Documentation Hub Space. Your prompt should reference the Space by name and mention following the documentation template.

   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Using my "FlavorHub - Documentation Hub" Space, generate comprehensive JavaDoc comments for this RecipeService class following the documentation template.
   ```
   </details>

3. **Review and apply the documentation** - Notice how Copilot follows the documentation standards and templates from your Space

4. **Generate additional documentation:**

   Create a prompt in Ask mode requesting a usage example for the service, referencing the Documentation Hub Space context.

   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Using the Documentation Hub Space context, create a usage example for this service with all its methods explained.
   ```
   </details>

### 💡 MCP + Spaces Best Practices:

1. **Be Explicit**: Always mention which Space you want to use by name
   ```
   Using my "Space Name" Space, ...
   ```

2. **Combine Contexts**: Reference both the Space and current file
   ```
   Using my Security Space, analyze the current file for vulnerabilities
   ```

3. **Iterate Quickly**: Test suggestions immediately in your IDE
   - Make changes
   - Run the application
   - Ask follow-up questions

4. **Stay Focused**: Use the appropriate Space for each type of work
   - Security reviews → Security Assessment Space
   - Documentation → Documentation Hub Space
   - Switch as needed for different aspects

5. **Leverage Both Environments**:
   - Use Space in browser for deep exploration and research
   - Use Space via MCP in IDE for active development and iteration
   - Each has its strengths!

### 🎯 Challenge Exercise: Full Workflow Integration

Put it all together with this comprehensive exercise:

1. **In your IDE**, open `flavorhub/src/main/resources/templates/index.html`

2. **Use your Security Space** to identify security improvements:
   ```
   Using my Security Assessment Space, what security enhancements should be made to this HTML template to prevent XSS attacks?
   ```

3. **Implement one security improvement** suggested by Copilot

4. **Use your Documentation Space** to document the change:
   ```
   Using my Documentation Hub Space, generate documentation for the security improvement I just implemented
   ```

5. **Create code comments** following the documentation Space's guidelines

6. **Test your implementation** in the running application

7. **Request a final review** from both Spaces:
   ```
   Using both my Security Assessment and Documentation Hub Spaces, review my changes for security compliance and documentation completeness
   ```

✅ **Success!** You've now integrated Copilot Spaces directly into your development workflow using GitHub MCP!

## 🏆 Exercise Wrap-up

Excellent work! You've mastered GitHub Copilot Spaces:
- ✅ Created TWO specialized Copilot Spaces with custom instructions
- ✅ Configured a Security Assessment Space with OWASP context
- ✅ Set up a Documentation Hub Space with documentation templates
- ✅ Added relevant context files and documentation to each Space
- ✅ Worked within Spaces for focused, goal-oriented AI assistance
- ✅ Accessed and used Spaces from your IDE via GitHub MCP
- ✅ Combined Space expertise with active development workflow
- ✅ Understood collaboration features and best practices
- ✅ Learned to organize and manage multiple Spaces

### Reflection Questions:
1. **How do Spaces differ from regular Copilot Chat in your workflow?**
2. **What types of projects or tasks would benefit most from dedicated Spaces?**
3. **How did accessing Spaces from your IDE via MCP change your development experience?**
4. **What was different about the responses from your Security Space vs. Documentation Space?**
5. **How might your team use Spaces for collaboration?**
6. **What instructions and context were most effective in your Spaces?**
7. **How would you organize Spaces for your current projects?**

### Key Takeaways:
- Spaces provide persistent, focused AI assistance for complex projects
- Each Space can have specialized instructions and curated context
- Custom instructions and relevant source files dramatically improve AI responses
- Different Spaces serve different purposes (security, docs, features, performance, etc.)
- Spaces work both in the browser (for exploration) and IDE (for active development)
- GitHub MCP integration brings Space expertise directly into your coding workflow
- Combining Space context with current code enables powerful, context-aware assistance
- Spaces enable better team collaboration and knowledge sharing
- Spaces are particularly valuable for long-running, complex initiatives

## Coming up next...

In the final lab, you'll learn about the GitHub Copilot Coding Agent:
- Assign entire issues to Copilot for autonomous development
- Experience parallel development by working on multiple tasks simultaneously
- Monitor progress through session logs and review pull requests
- Scale your productivity with multiple concurrent agent tasks
