# Exercise 7 - Model Context Protocol (MCP)

#### Duration: 15 minutes

## 🎯 Learning Objectives

By the end of this exercise, you will:
- Set up and use the GitHub MCP (Model Context Protocol) server in your IDE
- Leverage MCP to interact with GitHub repositories, issues, and pull requests through natural conversation
- Understand how MCP extends Copilot's capabilities
- Configure MCP servers for your development workflow

## 🍳 Scenario: Integrating GitHub Data at FlavorHub

Your team at FlavorHub needs better integration with GitHub for issue management and PR workflows. You want to access GitHub data directly from your IDE without switching contexts.

Today, you'll learn how to:
- Set up GitHub MCP server for seamless GitHub integration
- Interact with issues and PRs through natural language
- Configure MCP for optimal performance
- Extend Copilot with external data sources

## 🔌 Step 1: Understanding Model Context Protocol (MCP)

> [!IMPORTANT]
> If you are using a Codespace then you will not need to install the MCP server itself. However, you will need to configure it so that you can access all of the tools for these labs. The following process will be what you have to do when working in your IDEs directly.

[Model Context Protocol](https://github.com/modelcontextprotocol) acts as a mediator between your code base and external services. By combining GitHub Copilot with various external systems, you can expand the knowledge GitHub Copilot has access to:

- **Data stores**: Files and databases
- **Communication tools**: [Slack](https://docs.slack.dev/ai/mcp-server/)
- **Design platforms**: [Figma](https://help.figma.com/hc/en-us/articles/32132100833559-Guide-to-the-Figma-MCP-server)
- **Project management**: [Jira](https://github.com/atlassian/atlassian-mcp-server) or [Azure DevOps](https://devblogs.microsoft.com/devops/azure-devops-mcp-server-public-preview/)
- **Cloud providers**: [Azure](https://learn.microsoft.com/azure/developer/azure-mcp-server/get-started)
- And many, many more!

### Why MCP Matters:
- **Unified Interface**: Access external data without leaving your IDE
- **Natural Language**: Query systems through conversation with Copilot
- **Extensibility**: Connect any service that provides an MCP server
- **Context Enhancement**: Give Copilot access to real-time data from your tools

## 📥 Step 2: Installing the GitHub MCP Server

When looking to utilize MCP Servers, there are two primary ways of connecting your GitHub Copilot Client: through the MCP Registry and through manual configuration.

### Method 1: Using the MCP Registry (Recommended)

The [GitHub MCP Registry](https://github.com/mcp) provides a list of all currently available MCP Servers that can be easily and automatically installed.

#### Instructions:

1. **Open the MCP Registry** at https://github.com/mcp in a new browser tab

2. **Find the GitHub Server**

   <img width="557" height="170" alt="GitHub MCP Server in Registry" src="https://github.com/user-attachments/assets/82e8a1b8-066f-4a8f-858f-f6161b5d0732" />

3. **Click the "Install" drop-down**, then click "Install in VS Code"

4. **Accept opening VS Code** if prompted by your browser

5. **Click "Install"** on the extension page that appears in VS Code

6. **Link your GitHub account** to your IDE as prompted

### Method 2: Manual Configuration

To manually configure an MCP connection, you will need to decide where you want to store your configuration file:

- **Repository level**: Create a `.vscode/mcp.json` file
- **User level**: Add the configuration to your `settings.json` file in Visual Studio Code

Inside the chosen file, add a configuration like this:

```json
{
  "inputs": [
    // The "inputs" section defines the inputs required for the MCP server configuration.
    {
      "type": "promptString"
    }
  ],
  "servers": {
    // The "servers" section defines the MCP servers you want to use.
    "fetch": {
      "command": "uvx",
      "args": ["mcp-server-fetch"]
    }
  }
}
```

By finding and viewing the documentation for your third-party MCP Server, you will be able to retrieve any additional information that may be required for that particular configuration. The community maintains a list of common MCP servers at https://github.com/modelcontextprotocol/servers.

### ✅ Success Criteria
- [ ] GitHub MCP Server is installed
- [ ] GitHub account is linked to the IDE
- [ ] MCP Server appears in the Extensions tab

## ⚙️ Step 3: Configuring the MCP Tools List

To enable access to all of the tools available on the GitHub MCP server, you need to add a configuration to your `mcp.json`.

### Step 3.1: Access the Configuration File

**Option 1: Direct Access**
1. Open the File searcher: `Cmd+P` (Mac) or `Ctrl+P` (Windows/Linux)
2. Search for `mcp.json`

**Option 2: Through MCP Server Tab**
1. Open the `Extensions` tab
2. Click on the `MCP Servers - Installed` section at the bottom
3. Click the settings icon on the GitHub MCP
4. Click `Show Configuration (JSON)`

### Step 3.2: Update the Configuration

Once you have the `mcp.json` file opened, update it with the following:

```json
{
  "servers": {
    // Using OAuth (version 1.101 or greater)
    "github": {
      "type": "http",
      "url": "https://api.githubcopilot.com/mcp/",
      "headers": {
        "X-MCP-Toolsets": "all"
      }
    }
  }
}
```

Notice the additional headers compared to what was there before. This allows us to specify additional tool sets to make available. In this case we take all tools, but in practice you would want to be more specific.

> [!IMPORTANT]
> When prompting Copilot, you can only have 128 tools active at a given time. Anything beyond that will cause a degradation in performance.

### Understanding Tool Sets:

Instead of "all", you can specify specific tool sets:
- `"X-MCP-Toolsets": "issues,pull_requests"` - Only issue and PR tools
- `"X-MCP-Toolsets": "repositories,code_search"` - Only repository and search tools
- `"X-MCP-Toolsets": "all"` - All available tools

### ✅ Success Criteria
- [ ] `mcp.json` is updated with the new configuration
- [ ] Configuration includes the GitHub server with proper headers
- [ ] No syntax errors in the JSON

## 🚀 Step 4: Using GitHub MCP Effectively

The most effective way to use GitHub MCP is through natural conversation with Copilot, letting it automatically utilize the GitHub tools when needed.

Instead of explicitly calling `@github` or directly referencing a tool from the MCP, simply ask Copilot questions about your GitHub repositories in natural language. Copilot will automatically use the GitHub MCP tools when appropriate.

### Step 4.1: Enable Issues in Your Repository

> **Note:** Before testing out the MCP, ensure that you have Issues enabled in your repository
>   - Go to `Settings` > `General`
>   - Scroll to the `Features` section
>   - Check the `Issues` box (enable it)
>   - Return to the repository (refresh if needed) before proceeding

### Step 4.2: Try Natural Language Queries

**Finding Issues:**

Create a query asking about open issues with specific criteria (like a particular label) in your repository.

<details>
<summary>💡 Example Prompt</summary>

```
What open issues are labeled "bug" in this repository?
```
or
```
Show me all enhancement requests that haven't been assigned yet
```
</details>

**Working with Pull Requests:**

Create a query asking about the status of a pull request or finding PRs that need attention.

<details>
<summary>💡 Example Prompt</summary>

```
What's the current status of pull request #42?
```
or
```
Are there any PRs that need review?
```
</details>

**Analyzing Code Across Repositories:**

Create a query to find code examples or patterns across repositories in your organization.

<details>
<summary>💡 Example Prompt</summary>

```
Find examples of authentication middleware in my organization's repos
```
or
```
How do other repos in my org handle error logging?
```
</details>

### Step 4.3: Observe MCP in Action

When you ask these questions, observe:
- How Copilot automatically selects the right GitHub tools
- The structured data returned from GitHub
- How the response integrates GitHub data with code context
- No need to explicitly call `@github` or specific commands

## 💡 Step 5: MCP Best Practices

### Effective Prompting:
1. **Be Natural**: Ask questions in plain language
2. **Be Specific**: Include filters like labels, assignees, or status
3. **Trust Automation**: Let Copilot choose the right tools
4. **Iterate**: Refine your question if the first response isn't what you need

### Configuration Tips:
1. **Selective Tools**: Only enable tool sets you need for better performance
2. **Monitor Limits**: Stay under 128 tools for optimal performance
3. **Organization-wide**: Consider organization-level MCP configurations
4. **Security**: Review MCP server permissions and access

### Common Use Cases:
- **Issue Management**: Query, filter, and triage issues
- **PR Reviews**: Check PR status, get review feedback
- **Code Search**: Find patterns across repositories
- **Repository Info**: Get metadata, stats, and information
- **Team Collaboration**: Find work by team members

## 🌐 Step 6: Exploring Other MCP Servers

The MCP ecosystem extends far beyond GitHub. Consider adding these MCP servers based on your team's needs:

### Communication:
- **Slack MCP**: Access Slack channels, messages, and threads
- Query: "What did the team discuss about the API refactor?"

### Project Management:
- **Jira MCP**: Interact with Jira issues and projects
- Query: "Show me all high-priority tickets assigned to me"
- **Azure DevOps MCP**: Work with Azure DevOps work items
- Query: "What's the status of our current sprint?"

### Design:
- **Figma MCP**: Access Figma designs and components
- Query: "Show me the latest button component specs from Figma"

### Cloud:
- **Azure MCP**: Interact with Azure resources
- Query: "What's the current status of our production environment?"

### Development:
- **Database MCP**: Query databases directly
- **File System MCP**: Enhanced file operations
- **Git MCP**: Advanced Git operations

Visit https://github.com/modelcontextprotocol/servers for a complete list of available MCP servers.

## 📝 Step 7: Create an Issue for a Future Feature

Now that you've configured MCP and can interact with GitHub directly through Copilot, let's practice creating a well-structured GitHub issue that you'll use in a later lab.

### Step 7.1: Create a Recipe Rating System Issue

Instruct Copilot to open a GitHub issue for you to implement a recipe rating feature.

1. Use Plan mode to have Copilot come up with an implementation plan for the feature.
2. Then you can use Copilot and the GitHub MCP to open the issue.

**Tip: If you need guidance on how to instruct Copilot to open an issue or what to have Copilot put in the issue, an example prompt along with the issue template is provided below.**

### Using Copilot with MCP

Ask Copilot to create the issue for you using natural language.

<details>
<summary>💡 Example Prompt</summary>

```
Create a new GitHub issue in this repository with the following details:

Title: Add recipe rating system with star display

Description:
[Copy the full issue description from the template below]
```

</details>

<details>
<summary>💡 Issue Template</summary>

**Title:**
```
Add recipe rating system with star display
```

**Description:**
```markdown
## User Story
As a user, I want to rate recipes from 1-5 stars so I can share my opinion and help others find great recipes.

## Requirements

### Backend Changes
- [ ] Add `averageRating` field to Recipe entity (Double, default 0.0)
- [ ] Add `ratingCount` field to Recipe entity (Integer, default 0)
- [ ] Create `addRating` method in RecipeService:
  - Accepts recipeId (Long) and rating (Integer, 1-5)
  - Validates rating is between 1-5
  - Calculates new average: `((oldRating * oldCount) + newRating) / (oldCount + 1)`
  - Increments ratingCount
  - Saves updated recipe
- [ ] Add PUT endpoint `/api/recipes/{id}/rate` in RecipeController:
  - Request body: `{ "rating": 5 }`
  - Returns updated recipe with new rating
  - Returns 400 for invalid rating (not 1-5)
  - Returns 404 if recipe doesn't exist

### Frontend Changes
- [ ] Update `index.html` to display star ratings for each recipe
- [ ] Show visual star display (★★★★★ or ⭐ emoji) next to recipe names
- [ ] Display average rating and count (e.g., "4.2 stars (15 ratings)")
- [ ] Add interactive rating widget:
  - Show 5 clickable stars for users to submit ratings
  - Highlight stars on hover
  - Submit rating via API on click
  - Update displayed rating immediately after submission
- [ ] Add "Rate this recipe" button that shows rating widget
- [ ] Style ratings to match existing design (purple theme)
- [ ] Make ratings mobile-responsive

### Testing
- [ ] Unit tests for RecipeService.addRating() method
- [ ] Test valid rating updates average correctly
- [ ] Test validation rejects ratings < 1 or > 5
- [ ] Test edge cases (first rating, multiple ratings)
- [ ] Controller tests for rating endpoint

## Acceptance Criteria
- [ ] Recipe entity has rating fields with proper JPA annotations
- [ ] Service method correctly calculates average rating
- [ ] API endpoint validates input and returns appropriate status codes
- [ ] Stars display correctly on the recipes page
- [ ] Users can click stars to rate recipes
- [ ] Ratings update immediately without page refresh
- [ ] All tests pass
- [ ] Code follows Spring Boot coding standards
- [ ] Mobile-responsive design

## Technical Notes
- Use @Transactional on the service method
- Follow existing pattern from RecipeService methods
- Use Thymeleaf or vanilla JavaScript for frontend interactivity
- Reference existing HTML/CSS patterns in index.html
- Style stars with CSS (color: #667eea for filled, #ddd for empty)

## Examples

**Example 1: First rating**
- Current: averageRating = 0.0, ratingCount = 0
- User rates: 5 stars
- Result: averageRating = 5.0, ratingCount = 1

**Example 2: Multiple ratings**
- Current: averageRating = 4.5, ratingCount = 4
- User rates: 3 stars
- Result: averageRating = ((4.5 * 4) + 3) / 5 = 4.2, ratingCount = 5
```

</details>

> [!NOTE]
> Only use the manual method if you run in to issues utilizing the GitHub MCP

#### FALLBACK ONLY: Manual Creation on GitHub.com

1. Navigate to your repository on GitHub.com
2. Click the **Issues** tab
3. Click **"New issue"**
4. Use the template above

### Step 7.2: Verify the Issue

1. **Check the issue was created**: Navigate to the Issues tab and confirm your issue appears
2. **Review the content**: Make sure all sections are complete and clear
3. **Note the issue number**: You'll reference this issue in Lab 9

> [!NOTE]
> **Do not assign this issue to @copilot yet!** You'll do that in Lab 9 when you learn about the Coding Agent. For now, just create the issue and leave it unassigned.

### ✅ Success Criteria
- [ ] Issue created in your repository with the title "Add recipe rating system with star display"
- [ ] Issue description includes all sections: User Story, Requirements, Acceptance Criteria, Technical Notes, and Examples
- [ ] Issue is left unassigned (you'll assign it to @copilot in Lab 9)
- [ ] You understand how this issue will be used with Coding Agent in the next lab

## 🏆 Exercise Wrap-up

Excellent work! You've mastered Model Context Protocol integration:
- ✅ Installed and configured GitHub MCP server
- ✅ Used MCP to interact with GitHub repositories, issues, and PRs through natural conversation
- ✅ Learned to configure MCP tools for optimal performance
- ✅ Understood how MCP extends Copilot's capabilities
- ✅ Explored the broader MCP ecosystem

### Reflection Questions:
1. **How can GitHub MCP integration improve your development process?**
2. **What other MCP servers might benefit your team (Jira, Slack, database)?**
3. **What workflows could be streamlined with MCP integrations?**
4. **How would you balance tool availability with performance?**
5. **What security considerations should you keep in mind with MCP?**

### Key Takeaways:
- MCP extends Copilot's capabilities by connecting to external services
- Natural conversation with MCP is more effective than explicit commands
- Selective tool configuration maintains optimal performance
- The MCP ecosystem provides integrations for many popular tools
- MCP creates a unified interface for accessing diverse data sources
- Combining MCP with other Copilot features creates powerful workflows

## Coming up next...

In the next lab, you'll explore GitHub Copilot Spaces:
- Create dedicated AI workspaces for focused development
- Configure custom instructions and curated context for each Space
- Use Spaces from your IDE via MCP integration
- Apply Spaces to real-world collaboration scenarios
