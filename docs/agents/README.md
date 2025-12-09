# Custom Agent Examples

This directory contains example custom agent configurations for different programming languages and frameworks. These agents are specialized AI assistants that provide language-specific guidance, best practices, and code examples.

## Available Agents

### [Java Expert](./java-expert.md)
Specialized agent for Java development with Spring Boot focus.

**Best for:**
- Spring Boot applications
- Java enterprise patterns
- Maven/Gradle projects
- JUnit testing
- Microservices

### [C# Expert](./csharp-expert.md)
Specialized agent for .NET development with C#.

**Best for:**
- .NET applications
- C# best practices
- ASP.NET Core
- Entity Framework
- Azure development

### [C/C++ Expert](./cpp-expert.md)
Specialized agent for C and C++ development.

**Best for:**
- Modern C++ (C++11/14/17/20/23)
- Systems programming
- Performance-critical code
- Memory management
- CMake projects

### [Python Expert](./python-expert.md)
Specialized agent for Python development.

**Best for:**
- Django/Flask/FastAPI applications
- Data science projects
- Python scripting
- pytest testing
- Type hints and mypy

### [TypeScript/JavaScript Expert](./typescript-expert.md)
Specialized agent for modern TypeScript and JavaScript development with React, Next.js, and Node.js.

**Best for:**
- Next.js and React applications
- TypeScript type safety
- Modern JavaScript patterns
- Frontend and fullstack development

## How to Use These Agents

### 1. Create the Agent File

Create a new file in your repository's `.github/agents/` directory with the `.agent.yml` extension:

```bash
.github/agents/java-expert.agent.yml
```

### 2. Copy the Configuration

Copy the YAML configuration from the appropriate agent file in this directory into your new agent file.

### 3. Invoke the Agent

**In GitHub Copilot Chat (VS Code):**
- Select the agent from the agent dropdown
- Ask questions or request assistance

**With Copilot CLI:**
1. Run `copilot` to start an interactive session
    - If necessary go through the first start requirements (I.e. authenticating, configuring terminal, etc.)
2. Run 
```bash
agent java-expert "Help me optimize this Spring Boot service"
```

**With Copilot Coding Agent:**
- Assign the agent to an issue or pull request
- The agent will work autonomously on the task

## Organization-Wide Agents

To make an agent available to your entire organization:

1. Create a `.github` repository in your organization (if it doesn't exist)
2. Add your agent files to `agents/` in that repository
3. All organization members can now use these agents

## Best Practices

### When Creating Custom Agents

1. **Be Specific**: Define clear expertise and scope for each agent
2. **Include Context**: Provide language-specific best practices and conventions
3. **Test Thoroughly**: Test agents with various prompts before sharing
4. **Document Usage**: Include example prompts and use cases
5. **Iterate**: Refine agent instructions based on usage and feedback

### When Using Agents

1. **Choose the Right Agent**: Select the agent that matches your task
2. **Provide Context**: Give the agent enough information about your task
3. **Be Specific**: Clear, detailed prompts get better results
4. **Iterate**: Refine your prompts if the first response isn't quite right
5. **Combine Tools**: Agents can search, read files, and use other capabilities

## Learn More

- [About Custom Agents](https://docs.github.com/en/copilot/concepts/agents/coding-agent/about-custom-agents)
- [How to Create Custom Agents](https://docs.github.com/en/copilot/how-tos/use-copilot-agents/coding-agent/create-custom-agents)
- [Custom Agents Configuration Reference](https://docs.github.com/en/copilot/reference/custom-agents-configuration)
- [Awesome Copilot Agents](https://github.com/github/awesome-copilot) - Community-created agents

## Contributing

If you've created a useful custom agent and want to share it with the team, add it to this directory with:

1. A markdown file with the agent configuration and usage examples
2. Update this README with a link to your agent
3. Include example prompts that showcase the agent's capabilities
