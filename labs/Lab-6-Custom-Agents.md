# Exercise 6 - Custom Agents

#### Duration: 20 minutes

## 🎯 Learning Objectives

By the end of this exercise, you will:
- Understand what custom agents are and how they work
- Create custom agents for specialized development tasks
- Know when and how to use custom agents effectively
- Apply best practices for creating and sharing custom agents
- Use custom agents in different contexts (IDE, CLI, Coding Agent)

## 🍳 Scenario: Specialized AI Assistants at FlavorHub

Your team at FlavorHub works with multiple technologies and frameworks. Different team members specialize in different areas, and you need AI assistants that understand your specific tech stack and coding standards.

Today, you'll learn how to:
- Create specialized AI agents tailored to specific programming languages or frameworks
- Configure agents with expert knowledge and best practices
- Share agents across your team for consistent development practices
- Use agents in your workflow for autonomous task execution

## 🤖 Step 1: Understanding Custom Agents

### What are Custom Agents?

Custom agents are specialized AI assistants in GitHub Copilot that can be configured with specific expertise, instructions, and behaviors. Unlike the general-purpose Copilot, custom agents are designed for specific tasks, technologies, or workflows.

#### Key Capabilities:

- **Specialized Expertise**: Configure agents with deep knowledge of specific languages, frameworks, or domains
- **Autonomous Execution**: Agents can work independently on tasks, making multiple code changes
- **Tool Access**: Agents can search code, read files, edit code, and more
- **Organization-Wide**: Share agents across your entire organization for consistency
- **Multi-Context**: Use agents in VS Code, CLI, or with Copilot Coding Agent

#### Example Use Cases:

- A **Java Expert** agent that enforces Spring Boot best practices and design patterns
- A **Security Reviewer** agent that scans for vulnerabilities and suggests fixes
- A **Testing Specialist** agent that generates comprehensive test suites
- A **Documentation Writer** agent that creates and updates docs based on code changes
- A **Database Expert** agent that helps with query optimization and migrations

### Why Custom Agents?

1. **Consistency**: Ensure all team members follow the same coding standards
2. **Efficiency**: Agents handle routine tasks autonomously
3. **Expertise**: Embed expert knowledge that's always available
4. **Quality**: Built-in best practices reduce code review cycles
5. **Onboarding**: New team members get expert guidance instantly

## 📝 Step 2: Creating a Custom Agent

### Agent Configuration Structure

Custom agents are defined using YAML configuration files with markdown instructions:

```yaml
---
name: Agent Name
description: A brief description of what this agent does
---

Detailed instructions for how the agent should behave.
This is where you define the agent's expertise and approach.
```

### Step 2.1: Create Your First Agent

Let's create a Java expert agent for the FlavorHub project.

#### Instructions:

1. **Open GitHub Copilot Chat** in VS Code

2. **Click the settings gear icon (⚙️)** at the top of the Copilot Chat panel

3. **Select "Custom Agents"** from the menu

4. **Click "New Custom Agent"**

5. **Choose the location**: Select `.github/agents`

6. **Name the file**: Enter `java-expert` (the `.agent.yml` extension will be added automatically)

   This creates a file at `.github/agents/java-expert.agent.yml`

7. **Replace the template content** with the Java expert agent configuration

   You can find the complete configuration in [docs/agents/java-expert.md](../docs/agents/java-expert.md). Copy the configuration from that file into your new agent file.

### Step 2.2: Test Your Agent

Custom agents are available in VS Code, the Copilot CLI, and with Copilot Coding Agent.

#### Using in VS Code:

1. **Open Copilot Chat** in VS Code
2. **Select your custom agent** from the mode dropdown
3. **Test with a prompt**:
   
   ```
   Review the FlavorHub service classes and suggest improvements for Spring Boot best practices
   ```

#### Using with Copilot CLI:

If you have the Copilot CLI installed:

1. Run `copilot` to start an interactive session
    - If necessary go through the first start requirements (I.e. authenticating, configuring terminal, etc.)
2. Run 
```bash
agent java-expert "Review the FlavorHub service classes and suggest improvements for Spring Boot best practices"
```

#### Using with Copilot Coding Agent:

In Lab 9, you'll learn how to delegate tasks to Copilot Coding Agent and can select this custom agent as part of that workflow.

### ✅ Success Criteria
- [ ] Java Expert agent file is created
- [ ] Agent configuration follows the YAML format
- [ ] Instructions are clear and specific
- [ ] Agent can be invoked via CLI or Coding Agent

## 🎨 Step 3: Example Use Cases

Now let's explore how to use your custom agent for different scenarios.

### Scenario 1: Adding a Visual Recipe Card Display

**Prompt:**
```
Help me create a recipe card component for the home page. Each card should show the recipe name, difficulty level, prep time, and a colorful badge for the cuisine type. Make it visually appealing with CSS styling.
```

**What the agent does:**
- Designs HTML structure for the recipe card
- Creates CSS styling for visual appeal
- Implements responsive design patterns
- Adds proper Thymeleaf template syntax
- Suggests color schemes for difficulty badges

### Scenario 2: Building a Full-Stack Search Feature

**Prompt:**
```
Add a search and filter feature to the recipe browser. Users should see live results as they type, with dropdown filters for difficulty and cuisine. Include loading indicators and result counts.
```

**What the agent does:**
- Designs the UI layout with search input and filter controls
- Implements backend query methods in the repository
- Creates controller endpoints for filtered searches
- Adds JavaScript for live search functionality
- Includes visual feedback and smooth transitions

### Scenario 3: Improving Error Handling with User Feedback

**Prompt:**
```
The recipe API endpoints need better error handling. Show user-friendly error messages in the UI when recipes can't be loaded, searches fail, or pantry operations have issues.
```

**What the agent does:**
- Reviews current error handling in controllers
- Implements proper exception handling with @ControllerAdvice
- Creates user-friendly error message templates
- Adds visual error states to the UI (error banners, alerts)
- Ensures proper HTTP status codes and logging

## 🔍 Step 4: Exploring More Agent Examples

Your team might work with multiple technologies. The workshop includes example agents for different languages that you can reference or adapt.

### Available Example Agents

These examples are in the `docs/agents/` directory and can be used as templates:

1. **[TypeScript/JavaScript Expert](../docs/agents/typescript-expert.md)**
   - React and Node.js development
   - Modern JavaScript patterns
   - npm projects

2. **[C# Expert](../docs/agents/csharp-expert.md)**
   - .NET development
   - ASP.NET Core applications
   - Entity Framework

3. **[Java Expert](../docs/agents/java-expert.md)**
   - Spring Boot applications
   - Maven/Gradle projects
   - JUnit testing

4. **[C/C++ Expert](../docs/agents/cpp-expert.md)**
   - Modern C++ standards
   - Systems programming
   - CMake projects

5. **[Python Expert](../docs/agents/python-expert.md)**
   - Django/Flask/FastAPI
   - Data science projects
   - pytest testing

### How to Use These Examples:

1. **Browse** the example agents to understand different configuration approaches
2. **Copy** agent configurations that match your team's technology stack
3. **Customize** the instructions to match your team's specific conventions
4. **Share** agents with your team via organization-level configuration

## 🌟 Step 5: Best Practices for Custom Agents

### Creating Effective Agents

1. **Be Specific About Expertise**
   - Define clear domain knowledge
   - Specify frameworks and versions
   - Include relevant design patterns

2. **Provide Context and Constraints**
   - Include coding standards
   - Specify what to avoid
   - Define error handling approaches

3. **Include Examples**
   - Show preferred code patterns
   - Demonstrate naming conventions
   - Provide decision guidelines

4. **Keep Instructions Focused**
   - One agent, one domain of expertise
   - Don't try to make one agent do everything
   - Create multiple specialized agents instead

### Using Agents Effectively

1. **Choose the Right Agent**
   - Match the agent to your task
   - Use language-specific agents for language-specific tasks

2. **Provide Clear Prompts**
   - Be specific about what you want
   - Include relevant context
   - Mention files or components involved

3. **Iterate and Refine**
   - Review agent suggestions
   - Refine your prompts if needed
   - Improve agent instructions based on usage

4. **Share Knowledge**
   - Document agent purposes and use cases
   - Share successful prompts with team
   - Continuously improve agent instructions

## 🔧 Step 6: Organization-Wide Agents

### Sharing Agents Across Your Organization

To make agents available to your entire organization:

1. **Create a `.github` repository** in your organization (if it doesn't exist)

2. **Add agent files** to `agents/` in that repository:
   ```
   {org}/.github/
   └── agents/
       ├── java-expert.agent.yml
       ├── security-reviewer.agent.yml
       └── documentation-writer.agent.yml
   ```

3. **All organization members** can now use these agents in:
   - Copilot CLI
   - Copilot Coding Agent
   - VS Code (coming soon)

### Benefits of Organization-Wide Agents:

- **Consistency**: Everyone follows the same standards
- **Onboarding**: New team members get instant expert guidance
- **Quality**: Built-in code review and best practices
- **Efficiency**: Less time explaining standards and conventions

## 💡 Advanced Agent Configurations

### Specifying Tools

You can specify which tools an agent should have access to:

```yaml
---
name: Database Expert
description: Specialized in database design and optimization
tools: ['read', 'search', 'edit']
---
Instructions for database-specific tasks...
```

### Multi-Domain Agents

For specialized workflows that span multiple concerns:

```yaml
---
name: Full-Stack Feature Builder
description: Builds complete features across frontend and backend
---
You are a full-stack developer expert. When building features:

1. Design the database schema
2. Create API endpoints with proper validation
3. Build type-safe frontend components
4. Implement error handling across all layers
5. Add appropriate tests

Always ensure:
- Type safety across the stack
- Proper error handling
- Security best practices
- Performance considerations
```

## 🏆 Exercise Wrap-up

Excellent work! You've mastered custom agents in GitHub Copilot:
- ✅ Understood what custom agents are and their capabilities
- ✅ Created a Java expert agent for the FlavorHub
- ✅ Learned how to use agents for different scenarios
- ✅ Explored example agents for different languages
- ✅ Applied best practices for creating and using agents
- ✅ Learned how to share agents organization-wide

### Reflection Questions:
1. **What specialized agents would help your team work more efficiently?**
2. **How can custom agents improve code quality and consistency?**
3. **What workflows could be automated with custom agents?**
4. **How would you share agent best practices with your team?**

### Key Takeaways:
- Custom agents provide specialized AI assistance for specific tasks and technologies
- Agents can work autonomously, handling complex multi-step workflows
- Organization-wide agents ensure consistency across teams
- Well-designed agents embed expert knowledge that's always available
- Agents are usable in CLI, Coding Agent, and soon in VS Code

### 📚 Learn More:
- [About Custom Agents](https://docs.github.com/en/copilot/concepts/agents/coding-agent/about-custom-agents)
- [How to Create Custom Agents](https://docs.github.com/en/copilot/how-tos/use-copilot-agents/coding-agent/create-custom-agents)
- [Custom Agents Configuration Reference](https://docs.github.com/en/copilot/reference/custom-agents-configuration)
- [Awesome Copilot Agents](https://github.com/github/awesome-copilot) - Community examples

## Coming up next...

In the next lab, you'll explore Model Context Protocol (MCP):
- Understand how MCP extends GitHub Copilot with external tools
- Install and configure the GitHub MCP server
- Use natural language queries to interact with GitHub services
- Discover best practices and explore other MCP servers
