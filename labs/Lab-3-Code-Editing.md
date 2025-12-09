# Exercise 3 - Code Editing and Generation with GitHub Copilot

#### Duration: 40 minutes

## 🎯 Learning Objectives

By the end of this exercise, you will:
- Master GitHub Copilot's Edit mode for targeted code modifications
- Use GitHub Copilot's Plan mode to preview changes before execution
- Understand GitHub Copilot's Agent mode for multi-file code generation and modifications
- Understand when to use Edit mode vs. Plan mode vs. Agent mode in the IDE
- Generate new features and components with context-aware AI assistance
- Review and refine AI-generated code effectively
- Learn best practices for iterative AI-assisted development

## 🍳 Scenario: Enhancing FlavorHub Features

Your manager at FlavorHub has requested several new features that will require changes across multiple files. You've been tasked with implementing these enhancements efficiently while maintaining the high quality standards of the codebase.

Your task today is to use GitHub Copilot's Edit, Plan, and Agent modes to:
- Make targeted, deliberate changes to specific files with Edit mode
- Preview multi-file changes with Plan mode before execution
- Implement multi-file features with Agent mode assistance
- Create new components and integrate them into the application
- Make context-aware changes across the codebase

## 💡 Understanding GitHub Copilot Chat Modes

Before we dive into code generation, let's understand the different ways you can interact with GitHub Copilot in VS Code. GitHub Copilot Chat offers multiple modes, each optimized for different types of tasks:

| Mode | Trigger | Best For | Scope |
|------|---------|----------|-------|
| **Ask Mode** | Copilot Chat, select "Ask" | Understanding code, getting explanations, learning concepts | Read-only, no changes |
| **Edit Mode** | Copilot Chat, select "Edit" | Deliberate, specific changes to explicitly targeted files (1 to many files) | Targeted files you specify |
| **Plan Mode** | Copilot Chat, select "Plan" | Previewing changes before execution, understanding impact before committing | Shows detailed plan without making changes |
| **Agent Mode** | Copilot Chat, select "Agent" | Exploratory tasks, architectural planning, complex problem-solving | Workspace-wide, autonomous |

> **You learned Ask mode in Lab 2** where you explored the codebase. Now we'll focus on **Edit Mode**, **Plan Mode**, and **Agent Mode** for making code changes.

### 🎯 Understanding IDE Code Generation Modes

**When to use each mode:**

- **Ask Mode**: Use when you need to understand code first, want suggestions before implementation, or are exploring different approaches.

- **Edit Mode**: Use when you know exactly what needs to change and in which files. Edit mode makes deliberate, specific modifications to 1 to many files that you explicitly target. Perfect for focused refactoring, bug fixes, or feature additions where you control the scope.

- **Plan Mode**: Use when you want to preview what changes Copilot would make before executing them. Plan mode generates a detailed plan which can include showing: files to be modified, changes to be made, and the reasoning behind decisions, without actually applying any changes. Great for understanding impact and validating approach before committing.

- **Agent Mode**: Use when you need AI to explore your codebase, make decisions about architecture, or solve complex problems where the solution isn't immediately clear. Agent mode autonomously plans and executes changes across your workspace.

> **Note**: In this lab, you'll practice with **Edit mode**, **Plan mode**, and **Agent mode** to understand when to use each. **IDE Agent mode** (this lab) works interactively within VS Code, different from **Coding Agent** (Lab 9) which works autonomously on GitHub issues.

## 📝 Step 1: Using Edit Mode for Targeted Code Changes

While Agent mode is powerful for exploratory and autonomous work, Edit mode is ideal when you know exactly what needs to change. Let's start with Edit mode to make focused improvements to existing code.

### Exercise: Quick Refactoring with Edit Mode

Let's use Edit mode for a focused improvement to existing code in the homepage template.

### Instructions:

1. **Open the file** `flavorhub/src/main/resources/templates/index.html`

2. **Select lines 63-85** (the features section)

3. **Switch to Edit mode** in Copilot Chat

4. **Request a targeted improvement:**
   
   Create a prompt that asks Copilot to add hover effects and improve the visual styling of the feature cards.

   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Enhance the feature cards with hover effects and improved styling. Add smooth transitions and subtle shadows that activate on hover. Keep the existing color scheme.
   ```
   </details>

5. **Review the changes before accepting:**
   - Edit mode shows you a diff of what will change
   - You can see exactly what code is being added/removed
   - Accept if it looks good, or refine your prompt

6. **Keep and test:**
   - Click "Keep" to accept the changes
   - Save the file
   - Start the application if not running:
     ```bash
     cd flavorhub
     ./mvnw spring-boot:run
     ```
   - Open http://localhost:8080 and hover over the feature cards to see the effects

### 💡 Edit Mode Best Practices:

- **Be explicit about files**: Specify exactly which files should be modified
- **Be deliberate**: Know what you want changed before using Edit mode
- **Use for targeted scope**: Works on 1 to many files you explicitly name
- **Review diffs carefully**: Edit mode shows you exactly what will change
- **Control the changes**: You determine the scope, not the AI

## 📋 Step 2: Using Plan Mode to Preview Changes Before Execution

Now that you've made targeted changes with Edit mode, let's explore Plan mode. Plan mode lets you see exactly what Copilot would do before any code is modified, perfect for understanding impact and validating your approach.

**How Plan Mode Works:**
1. You describe what you want to accomplish
2. Copilot analyzes your codebase and creates a detailed plan
3. The plan shows:
   - Which files will be modified or created
   - What specific changes will be made to each file
   - The reasoning behind the changes
   - Dependencies and impacts
4. You review the plan without any code being changed
5. You can then execute the plan, modify your request, or try a different approach

**Benefits:**
- **Risk reduction**: See the impact before changes are made
- **Learning opportunity**: Understand AI's decision-making process
- **Better prompts**: Refine your request based on the preview
- **Confidence**: Proceed with changes knowing what will happen

**When to Use Plan Mode:**
- Before making significant refactoring changes
- When working with unfamiliar code sections
- To validate your approach before implementation
- When you want to understand AI's reasoning
- Before changes that might affect multiple files

### Exercise: Preview a Recipe Search Section with Plan Mode

Let's use Plan mode to preview adding an interactive recipe search section to the homepage. This will show you what files Copilot would create and modify, without actually making any changes yet.

### Instructions:

1. **Open GitHub Copilot Chat:**
   - Click the chat icon in the sidebar (or press `Ctrl+Alt+I` / `Cmd+Ctrl+I`)
   - Ensure you're in **Plan mode** (select "Plan" from the mode selector at the top)

2. **Provide context by opening related files:**
   - Open `flavorhub/src/main/resources/templates/index.html` to show where the search will be integrated
   - Open `flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java` to understand existing API patterns
   - Having these files open helps Plan mode understand your project patterns

3. **Request a plan for adding a recipe search section:**
   
   Create a prompt that asks Plan mode to show what changes would be needed to add an interactive search. Your prompt should specify:
   - Adding a search box to the homepage
   - Creating JavaScript to handle search with autocomplete
   - Displaying search results dynamically
   - Following the existing design system
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Add an interactive recipe search section to the homepage that allows users to search recipes in real-time.
   
   Requirements:
   - Add a search box to index.html after the welcome section
   - Create JavaScript that fetches from /api/recipes/search?query={term}
   - Display results as cards below the search box with recipe name, cuisine, and difficulty
   - Include autocomplete suggestions as user types
   - Style with modern CSS matching the existing purple gradient theme
   - Add smooth fade-in animations for results
   - Make it mobile-responsive
   - Show "No recipes found" when search returns empty
   
   Follow the patterns used in the existing HTML and styling.
   ```
   </details>

4. **Analyze the plan:**
   - Review what files Plan mode wants to create/modify
   - Check if the proposed changes align with your expectations
   - Look at the JavaScript approach it plans to use
   - Verify the styling approach matches existing components
   - Read the reasoning to understand AI's decision-making

5. **Note your observations:**
   - Does the plan look good?
   - Are there any files you didn't expect to be modified?
   - Is the approach what you would have taken?
   - Do you see any potential issues?

### 💡 Plan Mode Best Practices:

- **Use before significant changes**: Always preview complex refactoring or multi-file features
- **Validate AI's approach**: Check if the plan matches your mental model
- **Refine your prompt**: If the plan isn't right, adjust your request and try again
- **Compare alternatives**: Try different prompts to see different approaches
- **Learn from the reasoning**: Understand why AI makes certain decisions

## 🤖 Step 3: Using Agent Mode to Execute the Recipe Search Plan

Now that you've previewed the recipe search changes with Plan mode, let's use Agent mode to actually implement it. You'll see how Plan mode helps you understand what will happen, while Agent mode executes the changes.

### Exercise: Execute the Recipe Search with Agent Mode

We'll use the same requirements from Step 2, but this time Agent mode will actually create and modify files.

### Instructions:

1. **Switch to Agent mode:**
   - In the same Copilot Chat window, change from "Plan" to "Agent" mode

2. **Provide the same context:**
   - Ensure `flavorhub/src/main/resources/templates/index.html` is open
   - Ensure `flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java` is open
   - Agent mode will use these for context just like Plan mode did

3. **Have Agent mode implement the plan:**
   - Since Plan mode gave us all the steps to implement, we just need to tell Copilot to implement it!
   - Tell Copilot: `Implement the plan`

5. **Watch Agent mode work:**
   - Agent mode will modify the index.html file to add the search section
   - It will add JavaScript for search functionality
   - It will add CSS for styling
   - Changes appear in your editor in real-time
   - You can see the progress in the chat window

6. **Compare to the Plan mode preview:**
   - Are the actual changes similar to what Plan mode predicted?
   - Did Agent mode modify the expected files?
   - Are the code changes what you expected from the plan?
   - Note any differences between the plan and the execution

7. **Review the generated code:**
   - Check the updated `flavorhub/src/main/resources/templates/index.html` file
   - Review the JavaScript search functionality
   - Verify the styling matches existing components
   - Ensure the search integrates with the existing API

8. **Test your changes:**
   - `Keep` all of the changes and save all modified files
   - If the application isn't running, start it:
     ```bash
     cd flavorhub
     ./mvnw spring-boot:run
     ```
   - Open http://localhost:8080 in your browser
   - Try typing in the search box
   - Verify that search results appear dynamically
   - Test the autocomplete functionality
   - Check mobile responsiveness by resizing the browser

### 💡 Pro Tips for Agent Mode:

- **Be specific about file locations**: Specify exact paths where changes should be made
- **Reference existing patterns**: Point Agent mode to similar components to follow
- **Review before accepting**: Always check Agent mode's output before accepting it
- **Iterate if needed**: You can refine your prompt and try again if the plan isn't quite right. You don't have to opt to `Keep` anything to iterate. Simply type a follow-up prompt to Copilot and it will continue working.

### 🔍 Comparing Agent Mode vs Edit Mode:

**Example Scenario**: Adding input validation

**Edit Mode approach:**
```
Add input validation to the following files:
- flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java (in the search method)
- flavorhub/src/main/java/com/coveros/training/flavorhub/service/RecipeService.java (in the search service method)

Use @Valid annotations and proper error handling.
```
*Result: Targeted, deliberate changes to the 2 files you specified*

**Agent Mode approach:**
```
Analyze the application and add appropriate input validation wherever needed. 
Use your judgment to determine which controllers and services need validation, 
and how to handle invalid inputs gracefully with proper error messages.
```
*Result: AI autonomously explores, plans, and implements validation across multiple files*

### ⚠️ Key Difference:

**Edit Mode**: You tell Copilot what to change and where (1 to many specific files)  
**Agent Mode**: Copilot explores, decides what to change, and where to make those changes

## 🎯 Step 4: Using Agent Mode for Multi-File Feature Implementation

Now let's use Agent mode for a more complex task that involves creating a new feature across multiple files. This demonstrates Agent mode's real power.

### Scenario:

The application needs a "Recipe of the Day" section on the homepage that highlights a special recipe. This requires:
- Creating a backend endpoint
- Adding service logic
- Integrating it into the homepage UI
- Ensuring consistent styling

### Instructions:

1. **Prepare the context:**
   - Open `flavorhub/src/main/resources/templates/index.html` (the home page where feature will be added)
   - Open `flavorhub/src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java` (for controller pattern reference)
   - Open `flavorhub/src/main/java/com/coveros/training/flavorhub/service/RecipeService.java` (to see service patterns)

2. **Prompt Agent mode with the complete requirement:**

   Create a comprehensive prompt that covers the core requirements for adding a Recipe of the Day feature. Your prompt should specify:
   - Creating a new endpoint
   - Adding service method to select the daily recipe
   - Adding UI section to the homepage with styling and interactivity
   
   **Hint**: Using markdown format to create lists of requirements is a very effective method when working with AI
   
   <details>
   <summary>💡 Example Prompt</summary>

   ```
   Create a "Recipe of the Day" feature for the FlavorHub application.
   
   Tasks:
   1. Add a new endpoint GET /api/recipes/daily in RecipeController
   2. Add a service method in RecipeService that selects a recipe based on the current date (use a deterministic algorithm so the same recipe shows all day)
   3. Return the recipe with all its details
   4. Add proper error handling and logging
   5. Add a "Recipe of the Day" section to index.html after the welcome section
   6. Use JavaScript to fetch from /api/recipes/daily when the page loads
   7. Display the recipe in a highlighted card with:
      - Recipe name as a heading
      - Description
      - Cuisine type badge
      - Difficulty level badge (color-coded: Easy=green, Medium=yellow, Hard=red)
      - Cooking and prep times
      - A "View Full Recipe" button
   8. Style with the existing purple gradient theme
   9. Add smooth fade-in animation when the recipe loads
   10. Make it mobile-responsive
   
   Follow patterns from existing controllers, services, and the HTML styling.
   ```
   </details>

4. **Monitor the implementation:**
   - Watch as Agent mode creates/updates the controller
   - See it add the service method
   - Observe it integrate everything into the home page with full styling
   - Check that it follows existing patterns

5. **Review and test:**
   - Check each modified/created file
   - Verify the endpoint follows REST conventions
   - Verify the service method uses proper Spring annotations
   - Test the homepage at http://localhost:8080
   - Confirm the Recipe of the Day section appears with the highlighted styling
   - Test that the recipe displayed is deterministic (same all day)
   - Check responsiveness by resizing the browser
   - Verify the fade-in animation works

### 🔍 Understanding Agent Mode's Workflow:

When you accept the plan, Agent mode:
1. **Analyzes** your entire workspace and relevant files
2. **Plans** the sequence of changes needed
3. **Creates** new methods and endpoints with appropriate content
4. **Modifies** existing files to integrate the new feature
5. **Validates** that changes follow project patterns
6. **Applies** all changes atomically

## 🔄 Step 5: Iterating and Refining with Agent Mode

One of Agent mode's strengths is the ability to iterate on existing code. Let's practice this by enhancing an existing component or the one you created in Step 4.

### Scenario:

You want to add animations and improve the user experience for one of the sections on the homepage. This demonstrates iterative refinement with Agent mode.

### Instructions:

1. **Choose a section to enhance:**
   - Open `flavorhub/src/main/resources/templates/index.html`
   - Ensure the file is included as context (hint: `#index.html`)
   - You'll want to use the same chat session you used in Step 4

2. **Continue the conversation in Agent mode:**
   
   Agent mode remembers your previous conversation, so you can build on it. Create a prompt to enhance the Recipe of the Day section you created in Step 4:

   **If enhancing Recipe of the Day from Step 4:**
   - Your prompt should request improved animations
   - A button to refresh and show a random recipe
   - Loading state UI
   - Better mobile layout
   
      <details>
      <summary>💡 Example Prompt</summary>
   
      ```
      Enhance the Recipe of the Day section we just created:
      
      Improvements:
      1. Add smooth scale and fade-in animations when the recipe loads
      2. Add a "Show Random Recipe" button that fetches a different recipe
      3. Add hover effects on the recipe card (subtle shadow and lift)
      4. Add a loading spinner while the recipe is being fetched
      5. Improve the mobile layout to make text more readable on small screens
      6. Add a subtle background pattern or gradient to make the section stand out more
      
      Keep the purple gradient theme consistent with the rest of the page.
      ```
      </details>
   
   **If enhancing the search section instead:**
   - Your prompt should request better search UX
   - Keyboard navigation support
   - Search history
   - Empty state improvements
   
      <details>
      <summary>💡 Example Prompt</summary>
   
      ```
      Enhance the recipe search section:
      
      Improvements:
      1. Add keyboard navigation support (arrow keys to navigate results, Enter to select)
      2. Add a "Recent Searches" feature using localStorage (show last 5 searches)
      3. Add smooth slide-down animations when results appear
      4. Improve the empty state with a friendly message and search tips
      5. Add a search history dropdown that appears when clicking the search box
      6. Add a clear button (X) inside the search box to quickly clear the search
      
      Make sure animations are smooth and the UX feels polished.
      ```
      </details>

4. **Review agent modes changes:**
   - Agent mode will show what files it modifies as it works
   - Verify that it updates the index.html file appropriately
   - You should see new JavaScript functionality added
   - Accept the changes

5. **Test the improvements:**
   - Refresh the browser at http://localhost:8080
   - Test the new interactive features
   - Verify animations work smoothly
   - Resize the browser to check mobile responsiveness
   - Try all the new functionality you requested

6. **Request additional refinements if needed:**
   
   You can continue the conversation:
   ```
   Make the animation timing slower and more elegant
   ```
   
   Or:
   ```
   Add icons to the buttons using emoji or Unicode symbols
   ```

   OR:
   Have Copilot refine the changes to what you think will look best. There are no wrong answers!

### 💡 Benefits of Iterating with Agent Mode:

- **Context preservation**: Agent mode remembers what it just built
- **Incremental improvements**: Make changes step-by-step rather than all at once
- **Learning opportunity**: See how to progressively enhance features
- **Safe experimentation**: Easy to ask for changes and see results immediately

### 🔍 Providing Effective Feedback to Agent Mode:

When iterating, be specific about what you want changed:

**Good iteration prompts:**
- ✅ "Make the animation duration 0.5 seconds instead of the current timing"
- ✅ "Change the card shadow from subtle to more prominent on hover"
- ✅ "Add error handling for when the API endpoint fails"

**Less effective prompts:**
- ❌ "Make it better"
- ❌ "Fix the animations"
- ❌ "Improve performance"

### 🎯 Practice Exercise:

Try one more iteration on your own:
1. Ask Agent mode to add a recipe rating system (stars) displayed on each recipe card
2. Request that clicking the recipe name navigates to a detail page (you can just add a placeholder page)
3. Add a "Share Recipe" button that copies a link to the clipboard

### ⚠️ When to Stop Iterating:

Watch for signs that you should start a fresh conversation:
- The conversation history becomes very long
- Agent mode starts making unrelated changes
- You're changing direction significantly from the original task

**Tip**: Start a new Agent mode conversation for unrelated features

## 🎓 Step 6: Best Practices for IDE AI-Assisted Development

Let's review what makes for effective AI-assisted development in the IDE:

### ✅ Do's for Agent Mode:

1. **Let AI Explore and Decide**: Give high-level goals and let Agent mode determine the approach
   - ❌ "Modify these 3 specific files to add error handling"
   - ✅ "Add comprehensive error handling to the application where appropriate"

2. **Provide Context, Not Instructions**: Open relevant files to guide discovery
   - Open similar components for style patterns
   - Reference existing patterns: "Follow patterns in @RecipeController.java"
   - Let Agent mode decide which files to modify

3. **Use for Complex Problems**: Leverage Agent mode's autonomous capabilities
   - Architectural decisions and planning
   - Exploratory refactoring
   - Problems where the solution isn't immediately clear

4. **Review Plans Before Accepting**: Always check what Agent mode intends to do
   - Verify all files to be modified are correct
   - Ensure no unintended changes
   - Confirm the approach makes sense

5. **Iterate Conversationally**: Build on previous context
   - "Now add animations to the feature we just created"
   - "Enhance the Recipe of the Day section with hover effects"

### ✅ Do's for Edit Mode:

1. **Be Explicit About Files**: Tell Copilot exactly which files to modify
   - ✅ "Refactor the search styling in index.html"
   - ✅ "Add error handling to RecipeController.java, RecipeService.java, and RecipeRepository.java"

2. **Be Deliberate and Specific**: Know what you want changed
   - ✅ "Add hover effects and transitions to the feature cards"
   - ❌ "Improve this page" (too vague)

3. **Control the Scope**: Use Edit mode when you want to control exactly what changes
   - Specify 1 to many files explicitly
   - Define the exact changes needed
   - Maintain control over the modification scope

4. **Review Diffs**: Edit mode shows exactly what will change
   - Check additions and deletions carefully
   - Ensure functionality is preserved

### ❌ Universal Don'ts:

1. **Don't skip review**: Always understand generated code before using it
2. **Don't ignore errors**: If the application doesn't start, investigate and fix
3. **Don't forget testing**: Test all AI-generated code in the browser
4. **Don't lose context**: If conversations get long, start fresh
5. **Don't over-rely**: AI is a powerful assistant, **not a replacement for thinking**

### 🎯 Mode Selection Quick Guide:

| Scenario | Use This Mode | Why |
|----------|--------------|-----|
| Explore codebase and decide what to change | **Agent** | Autonomous discovery and planning |
| Complex problem where solution isn't clear | **Agent** | AI determines best approach |
| Architectural planning and implementation | **Agent** | Workspace-wide context and decisions |
| Refactor specific files you identify | **Edit** | Targeted changes to 1-many files you specify |
| Fix bug in known locations | **Edit** | Deliberate modifications with explicit control |
| Add feature to specific components | **Edit** | You control which files are changed |
| Preview changes before executing | **Plan** | See impact without modifying code |
| Validate approach before committing | **Plan** | Review plan and reasoning first |
| Understand code or get suggestions | **Ask** | Read-only exploration |

## 🏆 Exercise Wrap-up

Excellent work! You've mastered GitHub Copilot's IDE modes for code generation:
- ✅ Applied Edit mode for targeted, surgical code improvements to the UI
- ✅ Used Plan mode to preview changes before execution
- ✅ Understood the value of validating AI's approach before committing
- ✅ Used Agent mode to create multi-file features with full backend and frontend integration
- ✅ Implemented complex functionality across controllers, services, and HTML templates
- ✅ Iterated on AI-generated code to refine and enhance UI features
- ✅ Learned when to use each mode for maximum effectiveness

### Reflection Questions:
1. **How does Plan mode change your confidence when making large changes?**
2. **When would you use Plan mode before Agent mode?**
3. **How does Agent mode's multi-file capability change your development workflow?**
4. **When would you choose Edit mode over Plan or Agent mode, and why?**
5. **What surprised you about Agent mode's understanding of your codebase?**
6. **How might you use iterative prompting to build complex features?**
7. **What strategies will you use to provide better context to Copilot?**

### Key Takeaways:
- **Edit mode is perfect** for targeted changes when you know exactly what to modify
- **Plan mode is essential** for previewing changes and validating approaches before execution
- **Agent mode is the primary tool** for feature development requiring multiple files
- Use **Plan mode before Agent mode** for complex changes to build confidence
- Context is critical: open related files and reference existing patterns
- Iterative development with AI works just like with human developers
- Always review, test, and understand what AI generates
- Clear requirements and specific prompts yield better results
- **Balance backend and frontend work** for complete feature implementation

### 🎯 Real-World Applications:

**Plan Mode Use Cases:**
- Previewing refactoring before execution
- Validating approach for complex features
- Understanding impact of multi-file changes
- Learning AI's reasoning and decision-making

**Agent Mode Use Cases:**
- Building new features from scratch
- Adding REST endpoints with UI integration
- Implementing requirements that touch multiple layers (Controller, Service, Template)
- Refactoring that affects architecture

**Edit Mode Use Cases:**
- Quick bug fixes
- UI styling improvements in specific sections
- Adding error handling to existing code
- Refining HTML templates or Java methods

## Coming up next...

In the next lab, you'll explore engineering best practices with GitHub Copilot:
- Understand how Copilot makes decisions and inspect its reasoning process
- Configure personal instructions and custom settings for your workflow
- Learn to manage model usage and costs effectively
- Master the hierarchy of custom instructions for optimal AI assistance
