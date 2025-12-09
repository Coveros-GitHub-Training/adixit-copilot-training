# GitHub Copilot Advanced Workshop - FlavorHub

Welcome to the **GitHub Copilot Advanced Workshop**! This comprehensive workshop teaches you how to use GitHub Copilot as an AI-powered assistant throughout the software development lifecycle. Through practical exercises using a real-world recipe application, you'll learn to leverage Copilot for code generation, understanding, refactoring, and autonomous development.

## 🎯 Workshop Overview

This hands-on lab is designed to give developers practical experience using **GitHub Copilot** across all phases of the SDLC. Built around **FlavorHub**—a professional Spring Boot application for managing recipes and pantry ingredients—you'll explore how GitHub Copilot can improve developer productivity, code quality, and collaboration.

### What You'll Learn

Through guided, real-world exercises, you will:
- Understand GitHub Copilot's role across all phases of the SDLC
- Use AI-powered code completions directly within the IDE
- Leverage GitHub Copilot Chat in Ask, Edit, and Agent modes
- Explore GitHub Copilot Spaces for collaborative development
- Delegate tasks to the GitHub Copilot Coding Agent
- Optimize GitHub Copilot with Custom Instructions and Prompt Files
- Apply engineering best practices for AI-assisted development

## 📚 Lab Exercises

All lab exercises are located in the [`labs/`](labs/) directory:

| Lab | Title | Duration | Description |
|-----|-------|----------|-------------|
| [Lab 1](labs/Lab-1-Getting-Started.md) | Getting Started | 15 min | Set up your development environment and get introduced to FlavorHub |
| [Lab 2](labs/Lab-2-Exploring-the-Codebase.md) | Exploring the Codebase | 25 min | Use Copilot Chat to understand project structure, technologies, and architecture |
| [Lab 3](labs/Lab-3-Code-Editing.md) | Code Editing & Generation | 40 min | Master Edit mode and Agent mode for code generation and multi-file modifications |
| [Lab 4](labs/Lab-4-Engineering-Practices.md) | Engineering Practices & Copilot Instructions | 40 min | Debug Copilot's decisions, configure personal and repository instructions, switch models |
| [Lab 5](labs/Lab-5-Prompt-Files.md) | Prompt Files | 20 min | Create and use prompt files for consistent, reusable AI interactions |
| [Lab 6](labs/Lab-6-Custom-Agents.md) | Custom Agents | 20 min | Build custom agents for specialized, autonomous development workflows |
| [Lab 7](labs/Lab-7-Model-Context-Protocol.md) | Model Context Protocol (MCP) | 15 min | Set up GitHub MCP for seamless IDE integration with external services |
| [Lab 8](labs/Lab-8-Copilot-Spaces.md) | Copilot Spaces | 30 min | Create dedicated AI workspaces for focused, collaborative development and IDE integration |
| [Lab 9](labs/Lab-9-Coding-Agent.md) | Coding Agent | 60 min | Assign issues to Copilot for autonomous implementation and PR creation |

**Total Duration**: Approximately 4.5 hours

## 🚀 Quick Start

The first thing to do is to make sure that you create your own copy of this repository so that you can keep all of the work you do in this training.

This repository is set up as a template, so you can easily create your own copy from it!

1. From the `Code` tab of the repository click the green `Use this template` button in the top right.
2. Select `Create a new repository`
3. Here you select how you want to create the repository.
   - Owner: select either yourself or an organization you have access to
   - Visibility: select whatever option you prefer. (Note: for users in an EMU you will not be able to select public as an option)
   - Do not input anything for the Copilot prompt

### Option 1: GitHub Codespaces (Recommended)

The fastest way to get started:

1. Click the **"Code"** button on the repository page
2. Select the **"Codespaces"** tab
3. Click **"Create codespace on main"**
4. Wait for the environment to build (this may take a few minutes)

The codespace will automatically:
- Install Java 21 and Maven
- Install all dependencies
- Configure GitHub Copilot and VS Code extensions
- Build the FlavorHub application
- Provide a ready-to-use development environment

Once ready, navigate to the flavorhub directory and start the application:
```bash
cd flavorhub
./mvnw spring-boot:run
```

Open the forwarded port (default: 8080) to view the application.

### Option 2: Local Development

**Prerequisites:**
- Java Development Kit (JDK) 21 or newer
- Maven 3.6+ (or use included Maven Wrapper)
- Git
- Visual Studio Code (recommended)

**Setup:**
```bash
# Clone the repository
git clone https://github.com/<YOURORGANIZATION>/<YOURREPOSITORYNAME>.git
cd <YOURREPOSITORYNAME>/flavorhub

# Build and run the application
./mvnw spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080) to view the application.

## 📖 Getting Started

1. **Review the Glossary**: Start with the [Glossary](docs/Glossary.md) to familiarize yourself with Copilot terminology
2. **Start with Lab 1**: Begin with [Lab 1 - Getting Started](labs/Lab-1-Getting-Started.md)
3. **Follow the sequence**: Complete labs in order for the best learning experience
4. **Practice hands-on**: Each lab includes practical exercises and examples
5. **Reference as needed**: Use the [Glossary](docs/Glossary.md) to look up unfamiliar terms during the labs
6. **Explore freely**: Feel free to experiment beyond the guided exercises

## 🍳 About FlavorHub

The workshop uses **FlavorHub**, a Spring Boot application for managing recipes and pantry ingredients. This real-world application provides authentic scenarios for learning GitHub Copilot features.

### Technologies Used

- **Java 21** - Programming language
- **Spring Boot 3.2** - Application framework
- **Spring Data JPA** - Data persistence
- **H2 Database** - In-memory database
- **Maven** - Build tool
- **Lombok** - Reduces boilerplate code
- **Thymeleaf** - Template engine

### Application Features

- **Pantry Management**: Track ingredients with quantities and notes
- **Recipe Browser**: Browse and search recipes with detailed instructions
- **Smart Recommendations**: Get recipe suggestions based on pantry ingredients (to be implemented)
- **Advanced Filtering**: Filter by difficulty, cuisine type, and cooking time
- **RESTful API**: Complete REST API for all operations
- **In-Memory Database**: H2 database for quick setup and testing

## 🏗️ Repository Structure

```
.
├── labs/                  # Hands-on lab exercises (START HERE!)
├── docs/                  # Reference documentation
├── flavorhub/    # Spring Boot Application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/coveros/training/flavorhub/
│   │   │   │   ├── config/          # Configuration classes
│   │   │   │   ├── controller/      # REST API controllers
│   │   │   │   ├── model/          # Entity classes
│   │   │   │   ├── repository/     # Data access layer
│   │   │   │   ├── service/        # Business logic layer
│   │   │   │   └── FlavorHubApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── templates/      # HTML templates
│   │   └── test/                  # Test classes
│   ├── pom.xml                    # Maven configuration
│   └── README.md                  # Application-specific README
├── .github/
│   ├── prompts/         # Custom prompt files for Copilot
│   ├── agents/          # Custom AI agents
│   └── copilot-instructions.md  # Repository-level Copilot instructions
├── .devcontainer/       # GitHub Codespaces configuration
├── .vscode/            # VS Code settings and extensions
└── media/              # Workshop media assets
```

## 📝 Additional Resources

### Quick Reference
- **[Glossary](docs/Glossary.md)** ⭐ - Comprehensive guide to all Copilot terms, tools, and features covered in the labs

### Application Documentation
- [FlavorHub README](flavorhub/README.md) - Detailed application setup and usage guide

### Reference Materials
- [docs/](docs/) - Additional reference documentation and guides
  - [Premium Request Usage Guide](docs/Premium-Request-Usage.md) - Model pricing and optimization
  - [Copilot Instruction Best Practices](docs/Copilot-Instruction-Best-Practices.md) - Writing effective instructions
  - [Coding Agent Best Practices](docs/Coding-Agent-Best-Practices.md) - Autonomous development patterns
  - [Custom Agent Examples](docs/agents/) - Language-specific agent templates

## 🤝 Contributing

Contributions to improve the labs or add new exercises are welcome! Please:
1. Follow the existing lab structure and format
2. Maintain consistency with the FlavorHub scenario
3. Test all exercises thoroughly
4. Update documentation as needed

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

If you encounter issues or have questions:
- Check the [Glossary](docs/Glossary.md) for terminology clarification
- Review the lab instructions carefully
- Check the [FlavorHub README](flavorhub/README.md)
- Ask GitHub Copilot for help (it's great at explaining this codebase!)
- Create an issue in the repository for technical problems

---

**Ready to start?** Head to [Lab 1 - Getting Started](labs/Lab-1-Getting-Started.md) and begin your GitHub Copilot journey! 🚀
