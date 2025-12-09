# Exercise 4 - Engineering Practices and Copilot Instructions

#### Duration: 40 minutes

## 🎯 Learning Objectives

By the end of this exercise, you will:
- Understand how to debug and inspect Copilot's decision-making process using the Debug Panel
- Configure personal instructions for consistent code generation across all your projects
- Create and manage repository-specific instructions for team standardization
- Monitor premium request usage to manage costs effectively
- Switch between AI models for different tasks and understand their strengths
- Master the custom instructions hierarchy (personal, repository, organization)
- Apply best practices for instruction file creation in real-world projects

## 🍳 Scenario: Standardizing Development at FlavorHub

Your team at FlavorHub has been using GitHub Copilot for a few weeks now, and developers are getting great results. However, your manager has noticed some challenges:

- Different developers get varying code styles from Copilot for similar tasks
- Some developers get better results than others with similar prompts
- Team members aren't sure why Copilot makes certain suggestions
- The team needs to ensure consistent code patterns across the project
- Team members aren't sure which GitHub Copilot AI model to use for different scenarios

Today, you'll learn professional engineering practices for using GitHub Copilot effectively and explore instruction customization to:
- Understand AI decision-making through the Debug Panel
- Standardize code generation across the team with instruction files
- Optimize AI model usage for cost and efficiency
- Create effective instruction files that guide Copilot to produce high-quality, consistent code

## 🔍 Step 1: Understanding Copilot's Decision-Making

When using AI-assisted development in a professional environment, it's crucial to:
- **Understand the AI's reasoning** - Know why suggestions are made
- **Maintain standards** - Ensure consistent code quality across the team
- **Debug effectively** - Investigate when suggestions don't meet expectations

GitHub Copilot provides features specifically designed for professional engineers to address these needs.

### Step 1.1: Inspect Copilot's Decision-Making Process

Understanding how Copilot makes suggestions helps you write better prompts and trust the AI's recommendations. The debug view shows you exactly what context Copilot is using and how it formulates responses.

#### Why This Matters:
- **Improve prompts**: See what context Copilot has access to
- **Debug issues**: Understand why unexpected suggestions appear
- **Build trust**: Transparency in AI decision-making
- **Learn patterns**: Discover what makes effective prompts

#### Instructions:

**Method 1: Using Keyboard Shortcut**
1. Press `Ctrl + Shift + P` (Windows/Linux) or `Cmd + Shift + P` (Mac)
2. Type "Copilot Chat Debug"
3. Select **"Copilot Chat Debug: Focus on Copilot Chat Debug View"**

**Method 2: Through the Copilot Chat Window**
1. Open GitHub Copilot Chat
2. At the top of the Copilot Chat window, click the 3 ellipses `...`
3. Click **"Show Chat Debug View"**

#### What You'll See:

Once the debug panel opens, you can explore:

- **Prompts**: The actual prompts sent to the AI model
- **System Prompts**: Background instructions given to Copilot (from custom instructions, repository context, etc.)
- **Metadata**: Context information, model settings, and parameters
- **Response Details**: How Copilot formulated its suggestions, including tokens used

#### 🔬 Try This Experiment:

1. **Ask a simple question in Copilot Chat:**
   
   Create a prompt asking how the RecipeService class handles recipe recommendations.
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   How does the RecipeService class handle recipe recommendations?
   ```
   </details>

2. **Open the debug view** to see:
   - What files were included in the context
   - What system prompts were applied
   - How the query was processed

3. **Ask a more complex question:**
   
   Create a prompt that asks to refactor the recipes.html template to improve the filter functionality. Use the `@workspace` participant for better context.
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   @workspace How can I improve the recipes.html template to add real-time filtering without page refreshes?
   ```
   </details>

4. **Compare the debug information:**
   - Notice the difference in context files used
   - See how workspace references affect the prompt
   - Observe the system instructions that guide behavior
   - Note how Copilot handles both backend (Java) and frontend (HTML/JavaScript) contexts

#### 💡 Pro Tips:
- Use this when Copilot's suggestions seem unexpected - you can see exactly what context it's using
- Check the debug view if you're not getting relevant suggestions - you might need to add more context
- Review system prompts to understand what standards Copilot is following
- Look at token usage to optimize your prompts for efficiency

## 🎛️ Step 2: Personal Instructions and Custom Configuration

> [!IMPORTANT]
> Currently personal instructions are only supported for GitHub Copilot Chat in GitHub.com.

Personal instructions define how Copilot behaves across all repositories you work on. They're powerful for maintaining consistent coding standards and preferences.

### Step 2.1: Configure Personal Instructions

#### Why This Matters:
- **Consistency**: Get similar code style across all your projects
- **Efficiency**: Don't repeat common preferences in every chat
- **Customization**: Tailor Copilot to your specific needs and workflows

#### Access Personal Instructions

1. **Navigate to GitHub Copilot**: Go to [https://github.com/copilot](https://github.com/copilot)

2. **Open settings**: Click **Your profile icon** in the bottom left of the screen

3. **Open personal instructions**: Select **"Personal instructions"**

4. **Review existing instructions** (if any are already configured)

#### Create or Modify Personal Instructions

**Add a new personal instruction** that you'd like to test for this class.

<details>
  <summary>💡 Example Prompt</summary>

  **For Java Development:**
  ```
  Always use Java 21+ features when appropriate. Prefer records for data classes, 
  sealed classes for type hierarchies, and pattern matching for cleaner code.
  Use constructor injection with @RequiredArgsConstructor, never field injection.
  ```

  **For Spring Boot:**
  ```
  Follow Spring Boot best practices: use @Service for service classes, @Repository for repositories,
  return ResponseEntity<T> from REST controllers. Use proper HTTP status codes.
  Include @Transactional on service methods that modify data.
  ```

  **For Testing:**
  ```
  Write JUnit 5 tests with meaningful names following testMethod_WhenCondition_ThenResult pattern.
  Use AAA pattern (Arrange, Act, Assert). Mock external dependencies with Mockito.
  Include edge cases and error scenarios.
  ```

  **For Documentation:**
  ```
  Add Javadoc comments to all public methods with @param, @return, and @throws tags.
  Explain WHY, not just WHAT. Keep code self-documenting with meaningful names.
  ```

</details>

**💡 Help Creating Personal Instructions:**
If you're stuck, click the **lightbulb icon** in the bottom right of the textbox to insert a pre-built instruction template.

#### Test Your Personal Instructions

1. **After adding instructions**, return to VS Code

2. **Ask Copilot to generate some code:**
   
   Create a prompt asking Copilot to create a new service class for managing user meal plans.
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Create a new service class for managing user meal plans
   ```
   </details>

3. **Observe how the generated code** reflects your personal instructions

4. **Experiment with different instructions** to see how they affect output

#### 🔍 Things to Explore:

- How do personal instructions influence code style for both backend and frontend?
- What coding standards are enforced across different file types?
- How do the instructions interact with repository-level instructions?
- Do instructions apply consistently to Java, HTML, CSS, and JavaScript files?

## 📊 Step 3: Managing Model Usage and Costs

Understanding premium request usage and model costs is essential for optimizing your GitHub Copilot experience. GitHub Copilot offers different AI models—some with unlimited usage (0x models) and others that count against a monthly request allowance (premium models). 

Learning to monitor your usage, select the right model for each task, and manage costs effectively will help you work more efficiently. 

For comprehensive information about pricing structures, advanced monitoring strategies, cost optimization techniques, and model selection guidelines by task type, see the **[Premium Request Usage Guide](../docs/Premium-Request-Usage.md)**.

### Step 3.1: Experiment with Model Switching

Different AI models excel at different tasks. Learning which models work best for specific scenarios helps you work more efficiently.

#### Available Models:

GitHub Copilot provides access to models from:
- **OpenAI** (GPT series)
- **Anthropic** (Claude series)
- **Google** (Gemini series)
- **Auto** - Automatically selects the best model for your task at a 10% discount
- **Others** (constantly evolving)

For current models: [Supported Models Documentation](https://docs.github.com/copilot/reference/ai-models/supported-models)

#### About Auto Model Selection:

The **Auto** option intelligently selects the most appropriate model for your specific task:
- **Cost Savings**: Automatically get a 10% discount on premium request usage
- **Smart Selection**: GitHub analyzes your prompt and selects the optimal model
- **Simplified Workflow**: No need to manually choose between models for different tasks
- **Best Practice**: Ideal when you're unsure which model is best suited for your task

When to use Auto:
- When you want cost optimization without manual model selection
- For varied tasks where different models might be optimal
- When you're new to Copilot and learning which models work best
- For general development work without specific model requirements

#### Instructions:

Let's try the same coding task with different models and compare results.

1. **Update your mode to Edit**

2. **Add context files:**
   - Click `Add Context` in GitHub Copilot Chat
   - Add these files:
     - `/src/main/resources/templates/recipes.html`
     - `/src/main/resources/templates/index.html`
     - `/src/main/java/com/coveros/training/flavorhub/controller/HomeController.java`
   
   **Alternative method:**
   - Close all tabs
   - Open only these three files
   - Click `Add Context` → `Open Editors`

3. **Stay on recipes.html and highlight the JavaScript TODO section at the bottom**

4. **Select Model #1** from the model selector in Copilot Chat

5. **Ask a refactoring question:**
   
   Create a prompt asking Copilot to implement the recipe display functionality connecting the HTML template to the backend API.
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Implement the JavaScript in recipes.html to fetch recipes from the /api/recipes endpoint and display them in cards. Include filtering by difficulty and cuisine.
   ```
   </details>

6. **Note the response** - save or copy it for comparison

7. **Repeat steps 4-6 with two other models** (including trying the Auto option)

#### 💡 Comparison Questions:

After trying multiple models on both frontend and backend tasks, discuss or consider:
- Which model gave the most comprehensive explanation for UI work vs backend work?
- Which provided the best code quality for JavaScript vs Java?
- Which was fastest to respond for different types of tasks?
- Did any model excel at full-stack suggestions (connecting frontend to backend)?
- How did HTML/CSS/JavaScript improvements compare to Java improvements?
- Were best practices consistent across different languages and models?

#### When to Use Different Models:

Based on typical strengths (check current docs for specifics):
- **Quick code completions**: Fast, efficient models (works for both Java and JavaScript)
- **Complex refactoring**: Models good at reasoning (helpful for both backend logic and UI components)
- **Explanations**: Models with detailed communication (useful for understanding Spring Boot and frontend frameworks)
- **Performance optimization**: Models with deep analysis (applies to Java services and JavaScript rendering)
- **Full-stack tasks**: Models that handle context well (when working across backend APIs and frontend UI)

## 📋 Step 4: Understanding Custom Instructions Hierarchy

Custom instructions are rules that apply to every Copilot interaction. Which instructions are used depends on the context (personal, repository, or organization level).

### Step 4.1: Instructions Hierarchy

#### Hierarchy Levels:

1. **Personal Instructions** (highest priority)
   - Your individual preferences across all repos
   - Set at: https://github.com/copilot

2. **Repository Instructions** (medium priority)
   - Project-specific requirements
   - File: `.github/copilot-instructions.md`

3. **Organization Instructions** (lowest priority)
   - Company-wide standards
   - Set by org admins

#### ⚖️ Balancing Different Instruction Levels

**Personal Instructions**: Your individual preferences across all repositories
- How Copilot talks to you
- Outlining your coding style
- Comment and documentation preferences

**Repository Instructions**: Project-specific requirements (in `.github/copilot-instructions.md`)
- Project architecture patterns
- Specific libraries or frameworks to use
- Team coding standards

**Priority Order:**
1. Personal instructions (highest)
2. Repository instructions
3. Organization instructions (lowest)

When instructions conflict, higher priority ones take precedence.

### Step 4.2: Review Repository Instructions

1. **Open** `.github/copilot-instructions.md` in this repository

2. **Notice how it defines:**
   - Project overview and architecture
   - Backend patterns (Spring Boot, JPA, REST APIs)
   - Frontend patterns (Thymeleaf templates, HTML/CSS structure)
   - Coding conventions for both Java and web technologies
   - Development workflow

3. **Understand how these instructions:**
   - Automatically apply to all Copilot interactions
   - Guide code generation to follow project patterns for both backend and frontend
   - Maintain consistency across the full-stack codebase

#### Example Instructions in This Repo:

The repository instructions file (copilot-instructions.md) includes:
- Project structure overview (Java backend + Thymeleaf frontend)
- Spring Boot patterns and conventions
- HTML/CSS/JavaScript guidelines for templates
- Technology stack information
- Testing conventions for both backend and UI
- Best practices for this specific full-stack project

These instructions help Copilot generate code that fits seamlessly into the existing codebase, whether you're working on Java services, REST controllers, or HTML templates.

### Step 4.3: Auto-Generate Repository Instructions

Use the Copilot Chat "Generate Chat Instructions" feature to automatically create (or refine) the repository's `copilot-instructions.md`, then compare and improve it.

1. Open Copilot Chat  
2. Click the gear icon (Configure Chat) → choose **Generate Chat Instructions**
3. Look through the changes that Copilot has suggested making to the instructions file
4. Accept the changes that you think add value to the instructions, and `Undo` the ones that don't

> Tip: You should repeat this process routinely to ensure that the instructions always stay up to date with the codebase. This ensures that Copilot gets the best context possible when working within your code.

## 💎 Step 5: Best Practices for Creating Effective Instruction Files

Creating high-quality instruction files is essential for maximizing Copilot's effectiveness in production environments. Well-crafted instructions help teams maintain consistency, enforce standards, and guide AI-assisted development.

### Why Instruction Files Matter in Real Projects

In real-world development scenarios, instruction files serve several critical purposes:

- **Team Consistency**: Ensure all team members receive similar guidance from Copilot, regardless of their experience level
- **Code Quality**: Automatically enforce architectural patterns and coding standards across the project
- **Faster Onboarding**: Help new developers understand project conventions quickly without extensive documentation reviews
- **Enhanced Copilot Output**: Copilot is tuned to your repository specifics, and as such is much more accurate with its output

### Key Elements of Effective Instructions

When creating instruction files for your projects, focus on these essential elements:

1. **Architecture Patterns**: Be specific about folder structure, design patterns, and code organization
2. **Technology Stack**: Clearly define frameworks, libraries, and versions in use
3. **Code Style**: Specify naming conventions, file structure, and formatting preferences
4. **Component Patterns**: Document where different components live and how they should be structured
5. **Error Handling**: Define consistent approaches to error management and logging
6. **Security Requirements**: Specify security practices that should be followed
7. **Testing Standards**: Set expectations for test coverage and testing approaches
8. **Performance Guidelines**: Include optimization patterns and best practices
9. **Project-Specific Patterns**: Tailor instructions to your domain (e-commerce, recipes, etc.)

### 📖 Complete Guide

For comprehensive best practices, detailed real-world examples, and implementation strategies for creating effective instruction files, see:

**[Copilot Instruction Best Practices Guide](../docs/Copilot-Instruction-Best-Practices.md)**

This reference guide covers:
- Detailed examples for each best practice
- Real-world scenarios for different project types
- Advanced tips for versioning and maintaining instructions
- Common pitfalls to avoid
- Measuring effectiveness of your instruction files

## 🏆 Exercise Wrap-up

Excellent work! You've learned professional engineering practices and instruction customization for GitHub Copilot:
- ✅ Debugged and inspected Copilot's decision-making process using the Debug Panel
- ✅ Configured personal instructions for consistent code generation
- ✅ Monitored premium request usage to optimize costs
- ✅ Experimented with different AI models for various tasks
- ✅ Understood custom instructions hierarchy (personal, repository, organization)
- ✅ Learned best practices for creating effective instruction files

### Reflection Questions:
1. **How can the debug view help you write better prompts?**
2. **How might personal instructions improve your daily workflow?**
3. **What standards or preferences would you include in personal instructions?**
4. **How can monitoring usage help you make better model choices?**
5. **What differences did you notice between AI models?**
6. **What should go in personal vs. repository vs. organization instructions?**
7. **How can well-crafted instructions improve team productivity?**

### Key Takeaways:
- The Debug Panel provides transparency into AI decision-making
- Personal instructions maintain consistency across all your projects
- Repository instructions ensure team-wide coding standards
- Different AI models have different strengths and costs - choose wisely
- Instructions at different levels provide appropriate context (personal, repository, organization)
- These practices make AI-assisted development more professional and reliable
- Well-crafted instruction files multiply Copilot's effectiveness

## Coming up next...

In the next lab, you'll learn about Prompt Files:
- Understand the structure and power of prompt files
- Explore existing prompt files in the repository
- Create your own custom prompt files for common tasks
- Master advanced techniques like multiple variables and workspace context
